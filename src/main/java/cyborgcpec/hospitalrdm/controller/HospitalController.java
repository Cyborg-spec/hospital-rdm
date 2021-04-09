package cyborgcpec.hospitalrdm.controller;

import cyborgcpec.hospitalrdm.dto.HospitalCurrentMonthBoughtApparatusesDTO;
import cyborgcpec.hospitalrdm.dto.NewHospitalApparatusRequestDTO;
import cyborgcpec.hospitalrdm.exceptions.hospital.HospitalNotFoundException;
import cyborgcpec.hospitalrdm.model.Apparatus;
import cyborgcpec.hospitalrdm.model.Hospital;
import cyborgcpec.hospitalrdm.model.HospitalApparatus;
import cyborgcpec.hospitalrdm.model.HospitalApparatusBuyingHistory;
import cyborgcpec.hospitalrdm.model.composite_keys.HospitalApparatusId;
import cyborgcpec.hospitalrdm.service.ApparatusService;
import cyborgcpec.hospitalrdm.service.HospitalApparatusBuyingHistoryService;
import cyborgcpec.hospitalrdm.service.HospitalApparatusService;
import cyborgcpec.hospitalrdm.service.HospitalService;
import cyborgcpec.hospitalrdm.service.impl.HospitalApparatusBuyingHistoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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


    @PostMapping("/hospital/new-apparatus")
    public String newHospitalApparatus(@RequestBody NewHospitalApparatusRequestDTO newHospitalApparatusRequestDTO){
        Hospital hospital=hospitalService.findByName(newHospitalApparatusRequestDTO.getHospitalName());
        Apparatus apparatus=apparatusService.findByApparatusName(newHospitalApparatusRequestDTO.getApparatusName());
        HospitalApparatus hospitalApparatus=hospitalApparatusService.findByHospitalAndApparatus(hospital,apparatus);
        HospitalApparatusBuyingHistory hospitalApparatusBuyingHistory=new HospitalApparatusBuyingHistory();
        LocalDate boughtAt=LocalDate.now();
        int quantity=newHospitalApparatusRequestDTO.getQuantity();
        if(hospitalApparatus==null){
            hospitalApparatus=new HospitalApparatus();
            HospitalApparatusId hospitalApparatusId=new HospitalApparatusId();
            hospitalApparatusId.setApparatusId(apparatus.getApparatusId());
            hospitalApparatusId.setHospitalId(hospital.getHospitalId());
            hospitalApparatus.setHospitalApparatusId(hospitalApparatusId);
            hospitalApparatus.setApparatus(apparatus);
            hospitalApparatus.setHospital(hospital);
            hospitalApparatus.setQuantity(quantity);
        }else {
            hospitalApparatus.setQuantity(hospitalApparatus.getQuantity()+quantity);
        }
        hospitalApparatusService.save(hospitalApparatus);
        hospitalApparatusBuyingHistory.setHospital(hospital);
        hospitalApparatusBuyingHistory.setApparatus(apparatus);
        hospitalApparatusBuyingHistory.setBoughtAt(boughtAt);
        hospitalApparatusBuyingHistory.setBoughtQuantity(quantity);
        hospitalApparatusBuyingHistoryService.save(hospitalApparatusBuyingHistory);
        return "success";
    }
    @GetMapping("/hospital/{id}/month-spent-money")
    public long hospitalMonthSpentMoney(@PathVariable long id) throws HospitalNotFoundException {
        Hospital hospital=hospitalService.findByHospitalId(id);
        if(hospital!=null){
            List<HospitalCurrentMonthBoughtApparatusesDTO> hospitalCurrentMonthBoughtApparatuses=hospitalApparatusBuyingHistoryService.getHospitalCurrentMonthBoughtApparatuses(id);
            long apparatusesPrice=hospitalCurrentMonthBoughtApparatuses.stream().mapToLong(hp ->hp.getApparatusPrice()*hp.getBoughtQuantity()).sum();
            return apparatusesPrice;
        }else {
            throw new HospitalNotFoundException("Hospital not found");
        }
    }
}
