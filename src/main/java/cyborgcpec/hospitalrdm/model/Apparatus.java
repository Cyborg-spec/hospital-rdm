package cyborgcpec.hospitalrdm.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
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
    private long apparatusPrice;

    @Column(name = "apparatus_price_per_hour")
    private BigDecimal apparatusPricePerHour;

    @OneToMany(mappedBy = "apparatus")
    private Set<HospitalApparatusBuyingHistory> hospitalApparatusBuyingHistories;

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
