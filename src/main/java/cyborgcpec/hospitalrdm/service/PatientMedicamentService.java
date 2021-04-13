package cyborgcpec.hospitalrdm.service;

import cyborgcpec.hospitalrdm.dto.PatientUsedMedicamentDTO;
import cyborgcpec.hospitalrdm.model.Patient;
import cyborgcpec.hospitalrdm.model.PatientMedicament;

import java.util.List;
import java.util.Set;

public interface PatientMedicamentService {
    void save(PatientMedicament patientMedicament);
    Set<PatientMedicament> findByPatient(Patient patient);
    List<PatientUsedMedicamentDTO> getPatientUsedMedicamentByPatientId(long id);
}
