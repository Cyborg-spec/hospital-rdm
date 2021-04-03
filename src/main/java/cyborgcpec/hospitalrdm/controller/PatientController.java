package cyborgcpec.hospitalrdm.controller;

import cyborgcpec.hospitalrdm.dto.PatientDTO;
import cyborgcpec.hospitalrdm.mappers.EntityToDTOConverter;
import cyborgcpec.hospitalrdm.model.Patient;
import cyborgcpec.hospitalrdm.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private EntityToDTOConverter entityToDTOConverter;

    @GetMapping("/patient/{id}")
    public PatientDTO getPatientById(@PathVariable long id) throws Exception {
        Optional<Patient>patient=patientService.findById(id);
        if(patient.isPresent()){
           return entityToDTOConverter.patientToPatientDTO(patient.get());
        }else {
            throw new Exception();
        }
    }
}
