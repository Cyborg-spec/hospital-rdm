package cyborgcpec.hospitalrdm.service;

import cyborgcpec.hospitalrdm.dto.HospitalCurrentMonthBoughtApparatusesDTO;
import cyborgcpec.hospitalrdm.model.HospitalApparatusBuyingHistory;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface HospitalApparatusBuyingHistoryService {
    void save(HospitalApparatusBuyingHistory hospitalApparatusBuyingHistory);
    List<HospitalCurrentMonthBoughtApparatusesDTO> getHospitalCurrentMonthBoughtApparatuses(long hospitalId);

}
