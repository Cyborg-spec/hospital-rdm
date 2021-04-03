package cyborgcpec.hospitalrdm.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "hospital")
@Data
public class Hospital {
    @Id
    @Column(name = "hospital_id")
    private long hospitalId;

    @Column(name = "hospital_name")
    private String hospitalName;
}
