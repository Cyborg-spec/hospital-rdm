package cyborgcpec.hospitalrdm.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
@Data
public class Doctor {
    @Id
    @Column(name = "doctor_id")
    private long doctorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

}
