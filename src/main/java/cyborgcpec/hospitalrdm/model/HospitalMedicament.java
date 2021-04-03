package cyborgcpec.hospitalrdm.model;

import cyborgcpec.hospitalrdm.model.composite_IDs.HospitalMedicamentId;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hospital_medicament")
public class HospitalMedicament {
    @EmbeddedId
    private HospitalMedicamentId hospitalMedicamentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("hospitalId")
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("medicamentId")
    @JoinColumn(name = "medicament_id")
    private Medicament medicament;

    @Column(name = "quantity")
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HospitalMedicament that = (HospitalMedicament) o;
        return Objects.equals(hospital, that.hospital) && Objects.equals(medicament, that.medicament);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospital, medicament);
    }
}
