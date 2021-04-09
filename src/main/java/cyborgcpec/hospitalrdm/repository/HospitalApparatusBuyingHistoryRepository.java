package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.dto.HospitalCurrentMonthBoughtApparatusesDTO;
import cyborgcpec.hospitalrdm.model.HospitalApparatusBuyingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HospitalApparatusBuyingHistoryRepository extends JpaRepository<HospitalApparatusBuyingHistory, Long> {
}
