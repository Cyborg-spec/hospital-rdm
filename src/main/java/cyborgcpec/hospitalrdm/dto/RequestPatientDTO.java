package cyborgcpec.hospitalrdm.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestPatientDTO {
    private String firstName;
    private String lastName;
}
