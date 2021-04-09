package cyborgcpec.hospitalrdm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class HospitalCurrentMonthBoughtApparatusesDTO {
    private long apparatusPrice;
    private long boughtQuantity;
}
