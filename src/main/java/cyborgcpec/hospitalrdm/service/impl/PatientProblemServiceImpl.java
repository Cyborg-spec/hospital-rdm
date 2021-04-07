package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.model.PatientProblem;
import cyborgcpec.hospitalrdm.repository.PatientProblemRepository;
import cyborgcpec.hospitalrdm.service.PatientProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientProblemServiceImpl implements PatientProblemService {
    @Autowired
    private PatientProblemRepository problemRepository;

    @Override @Transactional
    public void save(PatientProblem patientProblem) {
        problemRepository.save(patientProblem);
    }
}
