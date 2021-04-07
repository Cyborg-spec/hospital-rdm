package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface ProblemRepository extends JpaRepository<Problem,Long> {
    @Query(value = "select from problem where problem_name in :problemNames",nativeQuery = true)
    Set<Problem> findByProblemNames(@Param("problemNames") Set<String> problemNames);

    Problem findByProblemName(String problemName);

}
