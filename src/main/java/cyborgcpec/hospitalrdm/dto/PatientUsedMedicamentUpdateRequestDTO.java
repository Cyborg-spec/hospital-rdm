package cyborgcpec.hospitalrdm.dto;


import lombok.Data;

import java.util.Set;

@Data
public class PatientUsedMedicamentUpdateRequestDTO {
    private String firstName;
    private String lastName;
    private Set<MedicamentDTO>usedMedicament;
    private int quantity;
}
