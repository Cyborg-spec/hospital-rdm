package cyborgcpec.hospitalrdm.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class NewApparatusRequestDTO {
    private String apparatusName;
    private long apparatusPrice;
    private BigDecimal apparatusPricePerHour;
}
