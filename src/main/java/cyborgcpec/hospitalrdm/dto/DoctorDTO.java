package cyborgcpec.hospitalrdm.dto;

import cyborgcpec.hospitalrdm.model.DoctorType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
    private String firstName;
    private String lastName;
    private int age;
    private String hospitalName;
    private DoctorType doctorType;
}
