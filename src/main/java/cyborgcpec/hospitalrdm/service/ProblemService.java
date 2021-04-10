package cyborgcpec.hospitalrdm.service;

import cyborgcpec.hospitalrdm.model.Problem;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface ProblemService {
    Problem findByProblemName(String problemName);
    Set<Problem> findByProblemNames(Set<String> problemNames);
    Set<Problem> findByPatient(long id);
}
