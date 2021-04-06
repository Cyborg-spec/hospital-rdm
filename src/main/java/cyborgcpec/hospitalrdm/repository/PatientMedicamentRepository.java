package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.PatientMedicament;
import cyborgcpec.hospitalrdm.model.composite_keys.PatientMedicamentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientMedicamentRepository extends JpaRepository<PatientMedicament, PatientMedicamentId> {
}
