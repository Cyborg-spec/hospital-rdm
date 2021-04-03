package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.Doctor;
import cyborgcpec.hospitalrdm.model.DoctorType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Set<Doctor> findByDoctorType(DoctorType type);
}
