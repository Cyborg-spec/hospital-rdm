package cyborgcpec.hospitalrdm.model;


import cyborgcpec.hospitalrdm.model.composite_IDs.HospitalApparatusId;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "hospital_apparatus")
@Data
public class HospitalApparatus {
    @EmbeddedId
    private HospitalApparatusId hospitalApparatusId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    private Apparatus apparatus;

    @Column(name = "quantity")
    private int quantity;
}
