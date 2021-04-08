package cyborgcpec.hospitalrdm.model;


import cyborgcpec.hospitalrdm.model.composite_keys.HospitalApparatusId;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hospital_apparatus")
@Data
public class HospitalApparatus {
    @EmbeddedId
    private HospitalApparatusId hospitalApparatusId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("hospitalId")
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("apparatusId")
    @JoinColumn(name = "apparatus_id")
    private Apparatus apparatus;

    @Column(name = "quantity")
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HospitalApparatus that = (HospitalApparatus) o;
        return Objects.equals(hospital, that.hospital) && Objects.equals(apparatus, that.apparatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospital, apparatus);
    }
}
