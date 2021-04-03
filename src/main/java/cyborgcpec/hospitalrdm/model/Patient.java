package cyborgcpec.hospitalrdm.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "patient")
@Data
public class Patient {
    @Id
    @Column(name = "patient_id")
    private long patientId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status_id")
    private Status status;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "patient")
    private Set<PatientApparatus> patientApparatuses;

}
