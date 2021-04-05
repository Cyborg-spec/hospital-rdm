package cyborgcpec.hospitalrdm.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apparatus apparatus = (Apparatus) o;
        return apparatusId == apparatus.apparatusId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(apparatusId);
    }
}
