package cyborgcpec.hospitalrdm.service;

import cyborgcpec.hospitalrdm.model.Medicament;

public interface MedicamentService {
    Medicament findByMedicamentName(String medicamentName);
}
