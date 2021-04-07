package cyborgcpec.hospitalrdm.service;

import cyborgcpec.hospitalrdm.model.Hospital;

import java.util.Optional;

public interface HospitalService {
    Optional<Hospital>findById(long id);
    Hospital findByName(String name);
}
