package cyborgcpec.hospitalrdm.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "patient_history")
@Data
public class PatientHistory {
    @Id
    @Column(name = "patient_history_id")
    private long patientHistoryId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "registered_at")
    private LocalDate registeredAt;

    @Column(name = "released_at")
    private LocalDate releasedAt;
}
