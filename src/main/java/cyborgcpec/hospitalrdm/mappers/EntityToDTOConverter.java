package cyborgcpec.hospitalrdm.mappers;


import cyborgcpec.hospitalrdm.dto.*;
import cyborgcpec.hospitalrdm.model.Apparatus;
import cyborgcpec.hospitalrdm.model.Doctor;
import cyborgcpec.hospitalrdm.model.Patient;
import cyborgcpec.hospitalrdm.model.Status;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class EntityToDTOConverter {
    public ResponsePatientDTO patientToPatientDTO(Patient patient){
        return ResponsePatientDTO.builder()
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .status(patient.getStatus().name())
                .doctor(doctorToDoctorDTO(patient.getDoctor()))
                .build();
    }
    public DoctorDTO doctorToDoctorDTO(Doctor doctor){
        return DoctorDTO
                .builder()
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .age(doctor.getAge()).build();
    }
    public ApparatusDTO apparatusToApparatusDTO(Apparatus apparatus){
       return ApparatusDTO.builder()
               .name(apparatus.getApparatusName())
               .price(apparatus.getApparatusPrice()).build();
    }
    public Set<ApparatusDTO> apparatusToApparatusDTO(Set<Apparatus>apparatuses){
        Set<ApparatusDTO>result=new HashSet<>();
        for(Apparatus apparatus:apparatuses){
            result.add(apparatusToApparatusDTO(apparatus));
        }
        return result;
    }
    public StatusDTO statusToStatusDTO(Status status){
        return StatusDTO.builder()
                .status(status.name()).build();
    }
}
