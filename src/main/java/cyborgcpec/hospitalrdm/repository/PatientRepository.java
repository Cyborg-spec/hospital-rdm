package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
