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

    @Column(name = "patient_first_name")
    private String firstName;

    @Column(name = "patient_last_name")
    private String lastName;

    @Column(name = "registered_at")
    private LocalDate registeredAt;

    @Column(name = "released_at")
    private LocalDate releasedAt;
}
