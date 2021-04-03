package cyborgcpec.hospitalrdm.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "apparatus")
@Data
public class Apparatus {
    @Id
    @Column(name = "apparatus_id")
    private long apparatusId;

    @Column(name = "apparatus_name")
    private String apparatusName;

    @Column(name = "apparatus_price")
    private BigDecimal apparatusPrice;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "apparatus")
    private Set<PatientApparatus>patientApparatuses;
}
