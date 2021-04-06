package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.model.Medicament;
import cyborgcpec.hospitalrdm.repository.MedicamentRepository;
import cyborgcpec.hospitalrdm.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentServiceImpl implements MedicamentService {
    @Autowired
    private MedicamentRepository medicamentRepository;

    @Override
    public Medicament findByMedicamentName(String medicamentName) {
        return medicamentRepository.findByMedicamentName(medicamentName);
    }
}
