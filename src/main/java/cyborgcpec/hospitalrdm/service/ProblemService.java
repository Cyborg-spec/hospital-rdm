package cyborgcpec.hospitalrdm.service;

import cyborgcpec.hospitalrdm.model.Problem;

public interface ProblemService {
    Problem findByProblemName(String problemName);
}
