package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.Apparatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ApparatusRepository extends JpaRepository<Apparatus,Long> {
    Apparatus findByApparatusName(String apparatusName);
}
