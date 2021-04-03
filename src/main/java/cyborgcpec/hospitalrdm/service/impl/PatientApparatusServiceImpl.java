package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.model.Patient;
import cyborgcpec.hospitalrdm.model.PatientApparatus;
import cyborgcpec.hospitalrdm.repository.PatientApparatusRepository;
import cyborgcpec.hospitalrdm.service.PatientApparatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PatientApparatusServiceImpl implements PatientApparatusService {
    @Autowired
    private PatientApparatusRepository patientApparatusRepository;

    @Override
    public Set<PatientApparatus> findByPatient(Patient patient) {
        return patientApparatusRepository.findByPatient(patient);
    }
}
