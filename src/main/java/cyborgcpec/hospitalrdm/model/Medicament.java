package cyborgcpec.hospitalrdm.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "medicament")
@Data
public class Medicament {
    @Id
    @GeneratedValue
    @Column(name = "medicament_id")
    private long medicamentId;

    @Column(name = "medicament_name")
    private String medicamentName;

    @Column(name = "medicament_price")
    private BigDecimal medicamentPrice;
}
