package cyborgcpec.hospitalrdm.model.composite_IDs;

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
public class PatientMedicamentId implements Serializable {
    @Column(name = "patient_id")
    private long patientId;

    @Column(name = "medicament_id")
    private long medicamentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientMedicamentId that = (PatientMedicamentId) o;
        return patientId == that.patientId && medicamentId == that.medicamentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, medicamentId);
    }
}