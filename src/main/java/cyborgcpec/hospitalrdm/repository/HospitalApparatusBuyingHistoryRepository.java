package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.HospitalApparatusBuyingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HospitalApparatusBuyingHistoryRepository extends JpaRepository<HospitalApparatusBuyingHistory, Long> {

}
