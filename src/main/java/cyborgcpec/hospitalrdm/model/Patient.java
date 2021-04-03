package cyborgcpec.hospitalrdm.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "patient")
@Data
public class Patient {
    @Id
    @GeneratedValue
    @Column(name = "patient_id")
    private long patientId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Enumerated(EnumType.STRING)
    private Status status;
}
