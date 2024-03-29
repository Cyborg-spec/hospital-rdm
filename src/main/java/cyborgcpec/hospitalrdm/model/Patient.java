package cyborgcpec.hospitalrdm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "patient")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(generator = "patient_id_gen")
    @SequenceGenerator(name = "patient_id_gen",sequenceName = "patient_id_seq",allocationSize = 1)
    @Column(name = "patient_id")
    private long patientId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Enumerated
    @Column(name = "status_id")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "patient")
    private Set<PatientProblem>patientProblems;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "patient")
    private Set<PatientMedicament>patientMedicaments;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "patient")
    private Set<PatientApparatus>patientApparatuses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return patientId == patient.patientId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId);
    }
}
