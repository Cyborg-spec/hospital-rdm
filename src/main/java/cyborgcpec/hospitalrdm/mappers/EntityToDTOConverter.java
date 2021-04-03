package cyborgcpec.hospitalrdm.mappers;


import cyborgcpec.hospitalrdm.dto.DoctorDTO;
import cyborgcpec.hospitalrdm.dto.PatientDTO;
import cyborgcpec.hospitalrdm.model.Doctor;
import cyborgcpec.hospitalrdm.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class EntityToDTOConverter {
    public PatientDTO patientToPatientDTO(Patient patient){
        return PatientDTO.builder()
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
}
