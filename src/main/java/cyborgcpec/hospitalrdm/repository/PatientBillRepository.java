package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.PatientBill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientBillRepository extends JpaRepository<PatientBill,Long> {
}
