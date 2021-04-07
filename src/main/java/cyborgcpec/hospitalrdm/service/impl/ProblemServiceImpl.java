package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.model.Problem;
import cyborgcpec.hospitalrdm.repository.ProblemRepository;
import cyborgcpec.hospitalrdm.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class ProblemServiceImpl implements ProblemService{
    @Autowired
    private ProblemRepository problemRepository;

    @Override
    @Transactional
    public Problem findByProblemName(String problemName) {
        return problemRepository.findByProblemName(problemName);
    }

    @Override
    @Transactional
    public Set<Problem> findByProblemNames(Set<String> problemNames) {
        return problemRepository.findByProblemNames(problemNames);
    }
}
