package cyborgcpec.hospitalrdm.service;

import cyborgcpec.hospitalrdm.model.Medicament;


import java.util.Set;

public interface MedicamentService {
    Medicament findByMedicamentName(String medicamentName);
    Set<Medicament> findByMedicamentNames(Set<String>medicamentNames);
    Set<Medicament> findByPatientId(long patientId);
}
