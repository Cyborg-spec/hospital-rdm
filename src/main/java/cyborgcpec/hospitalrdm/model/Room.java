package cyborgcpec.hospitalrdm.model;


import lombok.Data;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "room")
@Data
public class Room {
    @Id
    @Column(name = "room_id")
    private long roomId;

    @Enumerated
    @Column(name = "room_type_id")
    private RoomType roomType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

}
