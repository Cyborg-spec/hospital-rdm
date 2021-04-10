package cyborgcpec.hospitalrdm.mappers;

import cyborgcpec.hospitalrdm.dto.NewDoctorDTO;
import cyborgcpec.hospitalrdm.model.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DTOToEntityConverter {
   public Doctor doctorDTOToDoctor(NewDoctorDTO newDoctorDTO){
       return Doctor.builder()
               .doctorType(newDoctorDTO.getDoctorType())
               .age(newDoctorDTO.getAge())
               .firstName(newDoctorDTO.getFirstName())
               .lastName(newDoctorDTO.getLastName()).build();
   }
}
