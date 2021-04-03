package cyborgcpec.hospitalrdm.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "room")
@Data
public class Room {
    @Id
    @Column(name = "room_id")
    private long roomId;

    @OneToOne(fetch = FetchType.LAZY)
    private Doctor doctor;

    @OneToOne(fetch = FetchType.LAZY)
    private Patient patient;
}
