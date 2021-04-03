package cyborgcpec.hospitalrdm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private String firstName;
    private String lastName;
    private DoctorDTO doctor;
    private String status;
}
