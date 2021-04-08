package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.model.HospitalApparatusBuyingHistory;
import cyborgcpec.hospitalrdm.repository.HospitalApparatusBuyingHistoryRepository;
import cyborgcpec.hospitalrdm.service.HospitalApparatusBuyingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalApparatusBuyingHistoryImpl implements HospitalApparatusBuyingHistoryService {
    @Autowired
    private HospitalApparatusBuyingHistoryRepository hospitalApparatusBuyingHistoryRepository;

    @Override
    public void save(HospitalApparatusBuyingHistory hospitalApparatusBuyingHistory) {
        hospitalApparatusBuyingHistoryRepository.save(hospitalApparatusBuyingHistory);
    }
}
