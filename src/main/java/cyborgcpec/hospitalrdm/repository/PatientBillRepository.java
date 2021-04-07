package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.PatientBillHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientBillRepository extends JpaRepository<PatientBillHistory,Long> {
}
