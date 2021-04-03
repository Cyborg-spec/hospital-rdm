package cyborgcpec.hospitalrdm.model;

import cyborgcpec.hospitalrdm.model.composite_IDs.PatientApparatusId;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "patient_apparatus")
@Data
public class PatientApparatus {
    @EmbeddedId
    private PatientApparatusId patientApparatusId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("apparatusId")
    private Apparatus apparatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("patientId")
    private Patient patient;
}