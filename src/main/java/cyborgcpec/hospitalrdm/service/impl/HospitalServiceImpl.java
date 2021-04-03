package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.model.Hospital;
import cyborgcpec.hospitalrdm.model.HospitalApparatus;
import cyborgcpec.hospitalrdm.repository.HospitalRepository;
import cyborgcpec.hospitalrdm.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public Optional<Hospital> findById(long id) {
        return hospitalRepository.findById(id);
    }

}
