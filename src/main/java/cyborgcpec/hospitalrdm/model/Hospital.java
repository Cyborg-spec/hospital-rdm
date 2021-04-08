package cyborgcpec.hospitalrdm.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "hospital")
@Data
public class Hospital {
    @Id
    @Column(name = "hospital_id")
    private long hospitalId;

    @Column(name = "hospital_name")
    private String hospitalName;

    @OneToMany
    private Set<HospitalApparatus> apparatuses;

    @OneToMany
    private Set<HospitalApparatusBuyingHistory>hospitalApparatusBuyingHistories;
}
