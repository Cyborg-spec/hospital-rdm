package cyborgcpec.hospitalrdm.dto;

import lombok.Data;

@Data
public class PatientStatusUpdateRequestDTO {
    private String firstName;
    private String lastName;
    private String status;
}
