package cyborgcpec.hospitalrdm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HospitalApparatusResponseDTO {
    private String name;
    private long price;
    private int quantity;
}
