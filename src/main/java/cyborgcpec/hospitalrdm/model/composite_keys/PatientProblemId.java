package cyborgcpec.hospitalrdm.model.composite_keys;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientProblemId implements Serializable {
    @Column(name = "patient_id")
    private long patientId;

    @Column(name = "problem_id")
    private long problemId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientProblemId that = (PatientProblemId) o;
        return patientId == that.patientId && problemId == that.problemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, problemId);
    }
}
