package cyborgcpec.hospitalrdm.service;

import cyborgcpec.hospitalrdm.model.Patient;
import cyborgcpec.hospitalrdm.model.PatientApparatus;

import java.util.Set;

public interface PatientApparatusService {
    Set<PatientApparatus> findByPatient(Patient patient);
}
