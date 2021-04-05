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
public class HospitalMedicamentId implements Serializable {
    @Column(name = "hospital_id")
    private long hospitalId;

    @Column(name = "medicament_id")
    private long medicamentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HospitalMedicamentId that = (HospitalMedicamentId) o;
        return hospitalId == that.hospitalId && medicamentId == that.medicamentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospitalId, medicamentId);
    }

}
