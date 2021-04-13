package cyborgcpec.hospitalrdm.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PatientUsedMedicamentDTO {
    private String medicamentName;
    private BigDecimal medicamentPrice;
    private int usedQuantity;
}
