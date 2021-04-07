package cyborgcpec.hospitalrdm.service;

import cyborgcpec.hospitalrdm.model.Patient;
import cyborgcpec.hospitalrdm.model.PatientMedicament;

import java.util.Set;

public interface PatientMedicamentService {
    void save(PatientMedicament patientMedicament);
    Set<PatientMedicament> findByPatient(Patient patient);
}
