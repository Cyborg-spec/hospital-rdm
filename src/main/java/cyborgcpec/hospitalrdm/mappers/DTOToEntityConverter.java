package cyborgcpec.hospitalrdm.mappers;

import cyborgcpec.hospitalrdm.dto.DoctorDTO;
import cyborgcpec.hospitalrdm.dto.NewPatientDTO;
import cyborgcpec.hospitalrdm.model.Doctor;
import cyborgcpec.hospitalrdm.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class DTOToEntityConverter {
   public Doctor doctorDTOToDoctor(DoctorDTO doctorDTO){
       return Doctor.builder()
               .doctorType(doctorDTO.getDoctorType())
               .age(doctorDTO.getAge())
               .firstName(doctorDTO.getFirstName())
               .lastName(doctorDTO.getLastName()).build();
   }
}
