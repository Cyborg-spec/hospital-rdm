package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.PatientProblem;
import cyborgcpec.hospitalrdm.model.composite_keys.PatientProblemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientProblemRepository extends JpaRepository<PatientProblem, PatientProblemId> {

}
