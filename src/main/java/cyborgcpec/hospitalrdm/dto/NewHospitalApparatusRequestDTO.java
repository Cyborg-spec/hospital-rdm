package cyborgcpec.hospitalrdm.dto;

import lombok.Data;

@Data
public class NewHospitalApparatusRequestDTO {
    private String hospitalName;
    private String apparatusName;
    private int quantity;
}
