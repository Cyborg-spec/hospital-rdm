package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.model.Medicament;
import cyborgcpec.hospitalrdm.model.Patient;
import cyborgcpec.hospitalrdm.model.Problem;
import cyborgcpec.hospitalrdm.repository.PatientRepository;
import cyborgcpec.hospitalrdm.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    @Transactional
    public Optional<Patient> findById(long id) {
        return patientRepository.findById(id);
    }

    @Override
    @Transactional
    public Patient findByFirstNameAndLastName(String firstName, String lastName) {
        return patientRepository.findByFirstNameAndLastName(firstName,lastName);
    }

    @Override
    @Transactional
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    @Transactional
    public void delete(Patient patient) {
        patientRepository.delete(patient);
    }


}
