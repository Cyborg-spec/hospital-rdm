package cyborgcpec.hospitalrdm.model;

import cyborgcpec.hospitalrdm.model.composite_IDs.PatientMedicamentId;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "patient_medicament")
public class PatientMedicament {
    @EmbeddedId
    private PatientMedicamentId patientMedicamentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("patientId")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("medicamentId")
    private Medicament medicament;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientMedicament that = (PatientMedicament) o;
        return Objects.equals(patient, that.patient) && Objects.equals(medicament, that.medicament);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient, medicament);
    }
}
