package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.Patient;
import cyborgcpec.hospitalrdm.model.PatientMedicament;
import cyborgcpec.hospitalrdm.model.composite_keys.PatientMedicamentId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PatientMedicamentRepository extends JpaRepository<PatientMedicament, PatientMedicamentId> {
    Set<PatientMedicament>findByPatient(Patient patient);
}
