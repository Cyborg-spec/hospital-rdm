package cyborgcpec.hospitalrdm.model.composite_keys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientApparatusId implements Serializable {
    @Column(name = "patient_id")
    private long patientId;

    @Column(name = "apparatus_id")
    private long apparatusId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientApparatusId that = (PatientApparatusId) o;
        return patientId == that.patientId && apparatusId == that.apparatusId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, apparatusId);
    }
}
