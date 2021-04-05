package cyborgcpec.hospitalrdm.model;


import cyborgcpec.hospitalrdm.model.composite_keys.PatientProblemId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "patient_problem")
@Data
public class PatientProblem {
    @EmbeddedId
    private PatientProblemId patientProblemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("patientId")
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("problemId")
    @JoinColumn(name = "problem_id")
    private Problem problem;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientProblem that = (PatientProblem) o;
        return patient.equals(that.patient) && problem.equals(that.problem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient, problem);
    }
}
