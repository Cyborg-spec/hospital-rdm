package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.model.Problem;
import cyborgcpec.hospitalrdm.repository.ProblemRepository;
import cyborgcpec.hospitalrdm.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProblemServiceImpl implements ProblemService{
    @Autowired
    private ProblemRepository problemRepository;

    @Override
    public Problem findByProblemName(String problemName) {
        return problemRepository.findByProblemName(problemName);
    }
}
