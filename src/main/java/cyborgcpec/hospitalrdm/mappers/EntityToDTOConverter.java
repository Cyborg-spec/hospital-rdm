package cyborgcpec.hospitalrdm.mappers;


import cyborgcpec.hospitalrdm.dto.*;
import cyborgcpec.hospitalrdm.model.*;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class EntityToDTOConverter {
    public ResponsePatientDTO patientToPatientDTO(Patient patient) {
        return ResponsePatientDTO.builder()
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .status(patient.getStatus().name())
                .doctor(doctorToDoctorDTO(patient.getDoctor()))
                .build();
    }

    public DoctorDTO doctorToDoctorDTO(Doctor doctor) {
        return DoctorDTO
                .builder()
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .age(doctor.getAge())
                .doctorType(doctor.getDoctorType()).build();
    }

    public ApparatusDTO apparatusToApparatusDTO(Apparatus apparatus) {
        return ApparatusDTO.builder()
                .name(apparatus.getApparatusName())
                .price(apparatus.getApparatusPrice()).build();
    }

    public Set<ApparatusDTO> apparatusToApparatusDTO(Set<Apparatus> apparatuses) {
        Set<ApparatusDTO> result = new HashSet<>();
        for (Apparatus apparatus : apparatuses) {
            result.add(apparatusToApparatusDTO(apparatus));
        }
        return result;
    }

    public StatusDTO statusToStatusDTO(Status status) {
        return StatusDTO.builder()
                .status(status.name()).build();
    }

    public Set<ProblemDTO> patientProblemToProblemDTO(Set<PatientProblem> patientProblems) {
        Set<ProblemDTO> result = new HashSet<>();
        for (PatientProblem patientProblem : patientProblems) {
            result.add(problemToProblemDTO(patientProblem.getProblem()));
        }
        return result;
    }

    public ProblemDTO problemToProblemDTO(Problem problem) {
        return ProblemDTO.builder()
                .problemName(problem.getProblemName()).build();
    }

}
