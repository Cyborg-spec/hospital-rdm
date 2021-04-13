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
                .doctor(doctorToDoctorResponseDTO(patient.getDoctor()))
                .build();
    }

    public Set<ResponsePatientDTO> patientToPatientDTO(Set<Patient>patients){
        Set<ResponsePatientDTO>result=new HashSet<>();
        for(Patient patient:patients){
            result.add(patientToPatientDTO(patient));
        }
        return result;
    }

    public DoctorResponseDTO doctorToDoctorResponseDTO(Doctor doctor){
        return DoctorResponseDTO.builder()
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .age(doctor.getAge())
                .doctorType(doctor.getDoctorType()).build();
    }

    public Set<ProblemDTO> problemToProblemDTO(Set<Problem>problems){
        Set<ProblemDTO>result=new HashSet<>();
        for(Problem problem:problems){
            result.add(problemToProblemDTO(problem));
        }
        return result;
    }

    public NewDoctorDTO doctorToDoctorDTO(Doctor doctor) {
        return NewDoctorDTO
                .builder()
                .firstName(doctor.getFirstName())
                .hospitalName(doctor.getHospital().getHospitalName())
                .lastName(doctor.getLastName())
                .age(doctor.getAge())
                .doctorType(doctor.getDoctorType()).build();
    }

    public FindByDoctorTypeResponseDTO doctorToFindByDoctorTypeDTO(Doctor doctor){
        return FindByDoctorTypeResponseDTO.builder()
                .name(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .age(doctor.getAge())
                .build();
    }

    public Set<FindByDoctorTypeResponseDTO> doctorToFindByDoctorTypeDTO(Set<Doctor>doctors){
        Set<FindByDoctorTypeResponseDTO>result=new HashSet<>();
        for(Doctor doctor:doctors){
            result.add(doctorToFindByDoctorTypeDTO(doctor));
        }
        return result;
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

    public HospitalApparatusResponseDTO hospitalApparatusToHospitalApparatusResponseDTO(HospitalApparatus hospitalApparatus){
        return HospitalApparatusResponseDTO
                .builder()
                .name(hospitalApparatus.getApparatus().getApparatusName())
                .quantity(hospitalApparatus.getQuantity())
                .price(hospitalApparatus.getApparatus().getApparatusPrice())
                .build();
    }

    public Set<HospitalApparatusResponseDTO> hospitalApparatusToHospitalApparatusResponseDTO(Set<HospitalApparatus> hospitalApparatuses) {
        Set<HospitalApparatusResponseDTO> result = new HashSet<>();
        for (HospitalApparatus hospitalApparatus : hospitalApparatuses) {
            result.add(hospitalApparatusToHospitalApparatusResponseDTO(hospitalApparatus));
        }
        return result;
    }

}
