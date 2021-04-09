package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.model.Hospital;
import cyborgcpec.hospitalrdm.repository.HospitalRepository;
import cyborgcpec.hospitalrdm.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    @Transactional
    public Optional<Hospital> findById(long id) {
        return hospitalRepository.findById(id);
    }

    @Override
    public Hospital findByName(String name) {
        return hospitalRepository.findByHospitalName(name);
    }

    @Override
    public Hospital findByHospitalId(long id) {
        return hospitalRepository.findByHospitalId(id);
    }


}
