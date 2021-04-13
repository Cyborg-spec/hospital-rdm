package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.dto.PatientUsedMedicamentDTO;
import cyborgcpec.hospitalrdm.model.Medicament;
import cyborgcpec.hospitalrdm.repository.MedicamentRepository;
import cyborgcpec.hospitalrdm.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class MedicamentServiceImpl implements MedicamentService {
    @Autowired
    private MedicamentRepository medicamentRepository;

    @Override
    @Transactional
    public Medicament findByMedicamentName(String medicamentName) {
        return medicamentRepository.findByMedicamentName(medicamentName);
    }

    @Override
    @Transactional
    public Set<Medicament> findByMedicamentNames(Set<String> medicamentNames) {
        return medicamentRepository.findByMedicamentNames(medicamentNames);
    }

    @Override
    @Transactional
    public Set<Medicament> findByPatientId(long patientId) {
        return medicamentRepository.findByPatientId(patientId);
    }


}
