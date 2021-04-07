package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.model.PatientBillHistory;
import cyborgcpec.hospitalrdm.repository.PatientBillRepository;
import cyborgcpec.hospitalrdm.service.PatientBillHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientBillHistoryServiceImpl implements PatientBillHistoryService {
    @Autowired
    private PatientBillRepository patientBillRepository;


    @Override
    public void save(PatientBillHistory patientBillHistory) {
        patientBillRepository.save(patientBillHistory);
    }
}
