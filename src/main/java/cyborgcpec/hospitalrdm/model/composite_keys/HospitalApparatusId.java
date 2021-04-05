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
@AllArgsConstructor
@NoArgsConstructor
public class HospitalApparatusId implements Serializable {
    @Column(name = "apparatus_id")
    private long apparatusId;

    @Column(name = "hospital_id")
    private long hospitalId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HospitalApparatusId that = (HospitalApparatusId) o;
        return apparatusId == that.apparatusId && hospitalId == that.hospitalId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(apparatusId, hospitalId);
    }
}
