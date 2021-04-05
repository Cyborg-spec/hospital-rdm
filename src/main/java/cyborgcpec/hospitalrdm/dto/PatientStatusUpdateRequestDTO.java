package cyborgcpec.hospitalrdm.dto;

import lombok.Data;

@Data
public class PatientStatusUpdateRequestDTO {
    private long id;
    private String status;
}
