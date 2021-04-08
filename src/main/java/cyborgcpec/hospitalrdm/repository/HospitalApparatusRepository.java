package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.Apparatus;
import cyborgcpec.hospitalrdm.model.Hospital;
import cyborgcpec.hospitalrdm.model.HospitalApparatus;
import cyborgcpec.hospitalrdm.model.composite_keys.HospitalApparatusId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalApparatusRepository extends JpaRepository<HospitalApparatus, HospitalApparatusId> {
    HospitalApparatus findByHospitalAndApparatus(Hospital hospital, Apparatus apparatus);
}
