package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.model.Patient;
import cyborgcpec.hospitalrdm.repository.PatientRepository;
import cyborgcpec.hospitalrdm.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Optional<Patient> findById(long id) {
        return patientRepository.findById(id);
    }

    @Override
    public Patient findByFirstNameAndLastName(String firstName, String lastName) {
        return patientRepository.findByFirstNameAndLastName(firstName,lastName);
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }
}
