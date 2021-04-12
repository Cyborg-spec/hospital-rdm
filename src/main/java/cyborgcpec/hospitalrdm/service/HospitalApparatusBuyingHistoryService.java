package cyborgcpec.hospitalrdm.service;

import cyborgcpec.hospitalrdm.dto.HospitalBoughtApparatusesDTO;
import cyborgcpec.hospitalrdm.model.HospitalApparatusBuyingHistory;


import java.time.LocalDate;
import java.util.List;

public interface HospitalApparatusBuyingHistoryService {
    void save(HospitalApparatusBuyingHistory hospitalApparatusBuyingHistory);
    List<HospitalBoughtApparatusesDTO> getHospitalCurrentMonthBoughtApparatuses(long hospitalId);
    List<HospitalBoughtApparatusesDTO> getHospitalCurrentYearBoughtApparatuses(long hospitalId);
    List<HospitalBoughtApparatusesDTO> getHospitalFromDateToDateBoughtApparatuses(long hospitalId, String fromDate,String toDate);
}
