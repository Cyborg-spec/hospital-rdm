package cyborgcpec.hospitalrdm.controller;

import cyborgcpec.hospitalrdm.dto.*;
import cyborgcpec.hospitalrdm.exceptions.doctor.DoctorNotFoundException;
import cyborgcpec.hospitalrdm.exceptions.patient.PatientNotFoundException;
import cyborgcpec.hospitalrdm.mappers.EntityToDTOConverter;
import cyborgcpec.hospitalrdm.model.*;
import cyborgcpec.hospitalrdm.service.DoctorService;
import cyborgcpec.hospitalrdm.service.PatientApparatusService;
import cyborgcpec.hospitalrdm.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Objects;
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

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/patient/{id}")
    public ResponsePatientDTO getPatientById(@PathVariable long id) throws PatientNotFoundException {
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

    @GetMapping("/patient/status")
    public StatusDTO patientStatus(@RequestBody RequestPatientDTO requestPatientDTO) throws PatientNotFoundException {
        Patient patient=patientService.findByFirstNameAndLastName(requestPatientDTO.getFirstName(),requestPatientDTO.getLastName());
        if(patient!=null){
            return entityToDTOConverter.statusToStatusDTO(patient.getStatus());
        }else {
            throw new PatientNotFoundException("Patient not found");
        }
    }
    @PostMapping("/patient/new-patient")
    public ResponsePatientDTO newPatient(@RequestBody NewPatientDTO newPatientDTO) throws DoctorNotFoundException {
        //TODO doctorType throws IllegalArgumentException
        //TODO SET ROOM FOR PATIENT
        DoctorType doctorType=DoctorType.valueOf(newPatientDTO.getIllType());
        Set<Doctor>doctors=doctorService.findByDoctorType(doctorType);
        if(!doctors.isEmpty()) {

            Patient patient = new Patient();
            patient.setFirstName(newPatientDTO.getFirstName());
            patient.setLastName(newPatientDTO.getLastName());
            patient.setStatus(Status.UNDEFINED);
            Doctor availableDoctor = null;

            for (Doctor doctor : doctors) {
                if (doctor.getPatients().size() <= 3) {
                    availableDoctor = doctor;
                    break;
                }
            }

            patient.setDoctor(Objects.requireNonNullElseGet(availableDoctor, () -> doctors.stream().findAny().get()));

            patientService.save(patient);

            return entityToDTOConverter.patientToPatientDTO(patient);
        }else {
            throw new DoctorNotFoundException("Doctor for this patient not found");
        }
    }
}
