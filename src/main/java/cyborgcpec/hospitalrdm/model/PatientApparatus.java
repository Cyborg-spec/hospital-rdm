package cyborgcpec.hospitalrdm.model;

import cyborgcpec.hospitalrdm.model.composite_keys.PatientApparatusId;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "patient_apparatus")
@Data
public class PatientApparatus {
    @EmbeddedId
    private PatientApparatusId patientApparatusId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("apparatusId")
    @JoinColumn(name = "apparatus_id")
    private Apparatus apparatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("patientId")
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "started_using")
    private LocalDateTime startedUsing;

    @Column(name = "stopped_using")
    private LocalDateTime stoppedUsing;
}
