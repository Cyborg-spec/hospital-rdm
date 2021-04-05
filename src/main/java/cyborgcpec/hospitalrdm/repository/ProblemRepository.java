package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem,Long> {
    Problem findByProblemName(String problemName);
}
