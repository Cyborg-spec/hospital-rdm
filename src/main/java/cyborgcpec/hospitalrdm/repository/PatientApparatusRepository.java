package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.Patient;
import cyborgcpec.hospitalrdm.model.PatientApparatus;
import cyborgcpec.hospitalrdm.model.composite_IDs.PatientApparatusId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PatientApparatusRepository extends JpaRepository<PatientApparatus, PatientApparatusId> {
    Set<PatientApparatus> findByPatient(Patient patient);
}
