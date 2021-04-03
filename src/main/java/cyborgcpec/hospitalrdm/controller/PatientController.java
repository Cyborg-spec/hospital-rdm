package cyborgcpec.hospitalrdm.controller;

import cyborgcpec.hospitalrdm.dto.ApparatusDTO;
import cyborgcpec.hospitalrdm.dto.PatientDTO;
import cyborgcpec.hospitalrdm.exceptions.patient.PatientNotFoundException;
import cyborgcpec.hospitalrdm.mappers.EntityToDTOConverter;
import cyborgcpec.hospitalrdm.model.Apparatus;
import cyborgcpec.hospitalrdm.model.Patient;
import cyborgcpec.hospitalrdm.model.PatientApparatus;
import cyborgcpec.hospitalrdm.service.PatientApparatusService;
import cyborgcpec.hospitalrdm.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private EntityToDTOConverter entityToDTOConverter;

    @Autowired
    private PatientApparatusService patientApparatusService;

    @GetMapping("/patient/{id}")
    public PatientDTO getPatientById(@PathVariable long id) throws PatientNotFoundException {
        Optional<Patient>patient=patientService.findById(id);
        if(patient.isPresent()){
           return entityToDTOConverter.patientToPatientDTO(patient.get());
        }else {
            throw new PatientNotFoundException("Patient not found");
        }
    }

    @GetMapping("/patient/{id}/apparatuses")
    public Set<ApparatusDTO> getPatientApparatuses(@PathVariable long id) throws PatientNotFoundException {
        Optional<Patient>patient=patientService.findById(id);
        if(patient.isPresent()){
            Set<PatientApparatus>patientApparatuses=patientApparatusService.findByPatient(patient.get());
            Set<Apparatus>apparatuses=new HashSet<>();
            for(PatientApparatus patientApparatus:patientApparatuses){
                apparatuses.add(patientApparatus.getApparatus());
            }
           return entityToDTOConverter.apparatusToApparatusDTO(apparatuses);
        }else {
            throw new PatientNotFoundException("Patient not found");
        }
    }
}
