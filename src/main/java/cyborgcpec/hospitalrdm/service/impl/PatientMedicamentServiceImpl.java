package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.model.Patient;
import cyborgcpec.hospitalrdm.model.PatientMedicament;
import cyborgcpec.hospitalrdm.repository.PatientMedicamentRepository;
import cyborgcpec.hospitalrdm.service.PatientMedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class PatientMedicamentServiceImpl implements PatientMedicamentService {
    @Autowired
    private PatientMedicamentRepository patientMedicamentRepository;

    @Override
    @Transactional
    public void save(PatientMedicament patientMedicament) {
        patientMedicamentRepository.save(patientMedicament);
    }

    @Override
    @Transactional
    public Set<PatientMedicament> findByPatient(Patient patient) {
        return patientMedicamentRepository.findByPatient(patient);
    }
}
