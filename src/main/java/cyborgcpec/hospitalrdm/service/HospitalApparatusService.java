package cyborgcpec.hospitalrdm.service;

import cyborgcpec.hospitalrdm.dto.HospitalApparatusResponseDTO;
import cyborgcpec.hospitalrdm.model.Apparatus;
import cyborgcpec.hospitalrdm.model.Hospital;
import cyborgcpec.hospitalrdm.model.HospitalApparatus;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface HospitalApparatusService {
    HospitalApparatus findByHospitalAndApparatus(Hospital hospital, Apparatus apparatus);
    void save(HospitalApparatus hospitalApparatus);
    List<HospitalApparatusResponseDTO> findByHospitalId(long hospitalId);
}
