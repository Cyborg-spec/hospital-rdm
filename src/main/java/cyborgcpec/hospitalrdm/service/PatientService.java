package cyborgcpec.hospitalrdm.service;

import cyborgcpec.hospitalrdm.model.Patient;

import java.util.Optional;

public interface PatientService {
    Optional<Patient> findById(long id);
    Patient findByFirstNameAndLastName(String firstName,String lastName);
    void save(Patient patient);
}
