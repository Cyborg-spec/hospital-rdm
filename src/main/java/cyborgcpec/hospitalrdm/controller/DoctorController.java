package cyborgcpec.hospitalrdm.controller;

import cyborgcpec.hospitalrdm.dto.NewDoctorDTO;
import cyborgcpec.hospitalrdm.mappers.DTOToEntityConverter;
import cyborgcpec.hospitalrdm.mappers.EntityToDTOConverter;
import cyborgcpec.hospitalrdm.model.Doctor;
import cyborgcpec.hospitalrdm.model.DoctorType;
import cyborgcpec.hospitalrdm.model.Hospital;
import cyborgcpec.hospitalrdm.service.DoctorService;
import cyborgcpec.hospitalrdm.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class DoctorController {
    @Autowired
    private EntityToDTOConverter entityToDTOConverter;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DTOToEntityConverter dtoToEntityConverter;

    @Autowired
    private HospitalService hospitalService;

    @PostMapping("/doctor/add")
    public ResponseEntity<Object> addDoctor(@RequestBody NewDoctorDTO newDoctorDTO){
        Doctor doctor=dtoToEntityConverter.doctorDTOToDoctor(newDoctorDTO);
        Hospital hospital=hospitalService.findByName(newDoctorDTO.getHospitalName());
        doctor.setHospital(hospital);
        doctorService.save(doctor);
        return new ResponseEntity<>(newDoctorDTO, HttpStatus.OK);
    }

    @GetMapping("/doctor/find-by-type/{type}")
    public ResponseEntity<Object> findByType(@PathVariable String type){
        try {
            DoctorType doctorType=DoctorType.valueOf(type);
            Set<Doctor>doctors=doctorService.findByDoctorType(doctorType.ordinal());
            return new ResponseEntity<>(entityToDTOConverter.doctorToFindByDoctorTypeDTO(doctors),HttpStatus.OK);
        }catch (IllegalArgumentException illegalArgumentException){
            return new ResponseEntity<>("No such doctor type",HttpStatus.BAD_REQUEST);
        }
    }
}
