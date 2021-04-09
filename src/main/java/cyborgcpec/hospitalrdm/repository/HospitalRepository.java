package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {
    Hospital findByHospitalName(String name);
    Hospital findByHospitalId(long id);

}
