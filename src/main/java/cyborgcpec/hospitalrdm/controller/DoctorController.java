package cyborgcpec.hospitalrdm.controller;

import cyborgcpec.hospitalrdm.dto.DoctorDTO;
import cyborgcpec.hospitalrdm.mappers.DTOToEntityConverter;
import cyborgcpec.hospitalrdm.mappers.EntityToDTOConverter;
import cyborgcpec.hospitalrdm.model.Doctor;
import cyborgcpec.hospitalrdm.model.Hospital;
import cyborgcpec.hospitalrdm.service.DoctorService;
import cyborgcpec.hospitalrdm.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Object> addDoctor(@RequestBody DoctorDTO doctorDTO){
        Doctor doctor=dtoToEntityConverter.doctorDTOToDoctor(doctorDTO);
        Hospital hospital=hospitalService.findByName(doctorDTO.getHospitalName());
        doctor.setHospital(hospital);
        doctorService.save(doctor);
        return new ResponseEntity<>(doctorDTO, HttpStatus.OK);
    }
}
