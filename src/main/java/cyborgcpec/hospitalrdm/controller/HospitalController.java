package cyborgcpec.hospitalrdm.controller;

import cyborgcpec.hospitalrdm.dto.ApparatusDTO;
import cyborgcpec.hospitalrdm.dto.HospitalApparatusResponseDTO;
import cyborgcpec.hospitalrdm.dto.HospitalBoughtApparatusesDTO;
import cyborgcpec.hospitalrdm.dto.NewHospitalApparatusRequestDTO;
import cyborgcpec.hospitalrdm.exceptions.hospital.HospitalNotFoundException;
import cyborgcpec.hospitalrdm.mappers.EntityToDTOConverter;
import cyborgcpec.hospitalrdm.model.Apparatus;
import cyborgcpec.hospitalrdm.model.Hospital;
import cyborgcpec.hospitalrdm.model.HospitalApparatus;
import cyborgcpec.hospitalrdm.model.HospitalApparatusBuyingHistory;
import cyborgcpec.hospitalrdm.model.composite_keys.HospitalApparatusId;
import cyborgcpec.hospitalrdm.service.ApparatusService;
import cyborgcpec.hospitalrdm.service.HospitalApparatusBuyingHistoryService;
import cyborgcpec.hospitalrdm.service.HospitalApparatusService;
import cyborgcpec.hospitalrdm.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private HospitalApparatusBuyingHistoryService hospitalApparatusBuyingHistoryService;

    @Autowired
    private ApparatusService apparatusService;

    @Autowired
    private HospitalApparatusService hospitalApparatusService;

    @Autowired
    private EntityToDTOConverter entityToDTOConverter;

    @PostMapping("/hospital/new-apparatus")
    public String newHospitalApparatus(@RequestBody NewHospitalApparatusRequestDTO newHospitalApparatusRequestDTO) {
        Hospital hospital = hospitalService.findByName(newHospitalApparatusRequestDTO.getHospitalName());
        Apparatus apparatus = apparatusService.findByApparatusName(newHospitalApparatusRequestDTO.getApparatusName());
        HospitalApparatus hospitalApparatus = hospitalApparatusService.findByHospitalAndApparatus(hospital, apparatus);
        HospitalApparatusBuyingHistory hospitalApparatusBuyingHistory = new HospitalApparatusBuyingHistory();
        LocalDate boughtAt = LocalDate.now();
        int quantity = newHospitalApparatusRequestDTO.getQuantity();
        if (hospitalApparatus == null) {
            hospitalApparatus = new HospitalApparatus();
            HospitalApparatusId hospitalApparatusId = new HospitalApparatusId();
            hospitalApparatusId.setApparatusId(apparatus.getApparatusId());
            hospitalApparatusId.setHospitalId(hospital.getHospitalId());
            hospitalApparatus.setHospitalApparatusId(hospitalApparatusId);
            hospitalApparatus.setApparatus(apparatus);
            hospitalApparatus.setHospital(hospital);
            hospitalApparatus.setQuantity(quantity);
        } else {
            hospitalApparatus.setQuantity(hospitalApparatus.getQuantity() + quantity);
        }
        hospitalApparatusService.save(hospitalApparatus);
        hospitalApparatusBuyingHistory.setHospital(hospital);
        hospitalApparatusBuyingHistory.setApparatus(apparatus);
        hospitalApparatusBuyingHistory.setBoughtAt(boughtAt);
        hospitalApparatusBuyingHistory.setBoughtQuantity(quantity);
        hospitalApparatusBuyingHistoryService.save(hospitalApparatusBuyingHistory);
        return "success";
    }

    @GetMapping("/hospital/{id}/this-month-apparatus-spent-money")
    public long getHospitalCurrentMonthBoughtApparatuses(@PathVariable long id) throws HospitalNotFoundException{
        Hospital hospital = hospitalService.findByHospitalId(id);
        if (hospital != null) {
            List<HospitalBoughtApparatusesDTO> hospitalBoughtApparatusesDTO = hospitalApparatusBuyingHistoryService.getHospitalCurrentMonthBoughtApparatuses(id);
            return hospitalBoughtApparatusesDTO.stream().mapToLong(hp -> hp.getApparatusPrice() * hp.getBoughtQuantity()).sum();
        } else {
            throw new HospitalNotFoundException("Hospital not found");
        }
    }

    @GetMapping("/hospital/{id}/this-year-apparatus-spent-money")
    public long getHospitalCurrentYearBoughtApparatuses(@PathVariable long id) throws HospitalNotFoundException {
        Hospital hospital = hospitalService.findByHospitalId(id);
        if (hospital != null) {
            List<HospitalBoughtApparatusesDTO> hospitalBoughtApparatusesDTO = hospitalApparatusBuyingHistoryService.getHospitalCurrentYearBoughtApparatuses(id);
            return hospitalBoughtApparatusesDTO.stream().mapToLong(hp -> hp.getApparatusPrice() * hp.getBoughtQuantity()).sum();
        } else {
            throw new HospitalNotFoundException("Hospital not found");
        }
    }

    @GetMapping("/hospital/{id}/apparatus-spent-money/{from}/{to}")
    public long getHospitalFromDateToDateBoughtApparatuses(@PathVariable long id, @PathVariable("from") String fromDate, @PathVariable("to") String toDate) throws HospitalNotFoundException {
        Hospital hospital = hospitalService.findByHospitalId(id);
        if(hospital!=null){
            List<HospitalBoughtApparatusesDTO> hospitalBoughtApparatusesDTO=hospitalApparatusBuyingHistoryService.getHospitalFromDateToDateBoughtApparatuses(id,fromDate,toDate);
            return hospitalBoughtApparatusesDTO.stream().mapToLong(hp -> hp.getApparatusPrice() * hp.getBoughtQuantity()).sum();
        }else {
            throw new HospitalNotFoundException("Hospital not found");
        }
    }

    @GetMapping("/hospital/{id}/apparatuses")
    public List<HospitalApparatusResponseDTO> getHospitalApparatuses(@PathVariable long id) throws HospitalNotFoundException {
        Hospital hospital=hospitalService.findByHospitalId(id);
        if(hospital!=null){
            List<HospitalApparatusResponseDTO>hospitalApparatuses=hospitalApparatusService.findByHospitalId(id);
            return hospitalApparatuses;
        }else {
            throw new HospitalNotFoundException("Hospital not found");
        }
    }
}
