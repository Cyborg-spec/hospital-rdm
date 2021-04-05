package cyborgcpec.hospitalrdm.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "room")
@Data
public class Room {
    @Id
    @Column(name = "room_id")
    private long roomId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Enumerated
    @Column(name = "room_type_id")
    private RoomType roomType;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "room")
    private Set<Patient> patient;

}
