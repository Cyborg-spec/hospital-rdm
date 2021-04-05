package cyborgcpec.hospitalrdm.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientNewProblemDTO {
    private String firstName;
    private String lastName;
    private Set<ProblemDTO>problems;
}
