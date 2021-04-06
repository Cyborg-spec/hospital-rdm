package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.model.PatientMedicament;
import cyborgcpec.hospitalrdm.repository.PatientMedicamentRepository;
import cyborgcpec.hospitalrdm.service.PatientMedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientMedicamentServiceImpl implements PatientMedicamentService {
    @Autowired
    private PatientMedicamentRepository patientMedicamentRepository;

    @Override
    public void save(PatientMedicament patientMedicament) {
        patientMedicamentRepository.save(patientMedicament);
    }
}
