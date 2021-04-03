package cyborgcpec.hospitalrdm.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

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

    @Enumerated
    @Column(name = "doctor_type_id")
    private DoctorType doctorType;

    @OneToMany(mappedBy = "doctor")
    private Set<Patient> patients;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return doctorId == doctor.doctorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId);
    }
}
