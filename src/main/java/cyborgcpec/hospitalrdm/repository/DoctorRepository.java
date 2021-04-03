package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
