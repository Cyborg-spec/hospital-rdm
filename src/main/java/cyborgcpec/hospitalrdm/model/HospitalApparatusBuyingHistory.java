package cyborgcpec.hospitalrdm.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hospital_apparatus_buying_history")
@Data
public class HospitalApparatusBuyingHistory {
    @Id
    @Column(name = "hospital_apparatus_buying_history_id")
    @GeneratedValue(generator = "hospital_apparatus_buying_history_gen")
    @SequenceGenerator(name = "hospital_apparatus_buying_history_gen",sequenceName = "hospital_apparatus_buying_history_seq",allocationSize = 1)
    private long hospitalApparatusBuyingHistoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apparatus_id")
    private Apparatus apparatus;

    @Column(name = "bought_at")
    private LocalDate boughtAt;

    @Column(name = "bought_quantity")
    private long boughtQuantity;
}
