package cyborgcpec.hospitalrdm.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewPatientDTO {
    private String firstName;
    private String lastName;
    private int age;
    private String illType;
}
