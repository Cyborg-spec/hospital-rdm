package cyborgcpec.hospitalrdm.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "apparatus")
public class Apparatus {
    @Id
    @GeneratedValue
    @Column(name = "apparatus_id")
    private long apparatusId;

    @Column(name = "apparatus_name")
    private String apparatusName;

    @Column(name = "apparatus_price")
    private BigDecimal apparatusPrice;
}
