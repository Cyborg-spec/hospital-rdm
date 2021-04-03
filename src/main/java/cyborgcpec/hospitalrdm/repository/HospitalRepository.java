package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {
}
