package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.model.PatientBill;
import cyborgcpec.hospitalrdm.repository.PatientBillRepository;
import cyborgcpec.hospitalrdm.service.PatientBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientBillServiceImpl implements PatientBillService {
    @Autowired
    private PatientBillRepository patientBillRepository;


    @Override
    public void save(PatientBill patientBill) {
        patientBillRepository.save(patientBill);
    }
}
