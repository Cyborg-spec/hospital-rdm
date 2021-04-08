package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.model.Apparatus;
import cyborgcpec.hospitalrdm.model.Hospital;
import cyborgcpec.hospitalrdm.model.HospitalApparatus;
import cyborgcpec.hospitalrdm.repository.HospitalApparatusRepository;
import cyborgcpec.hospitalrdm.service.HospitalApparatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalApparatusServiceImpl implements HospitalApparatusService {
    @Autowired
    private HospitalApparatusRepository hospitalApparatusRepository;

    @Override
    public HospitalApparatus findByHospitalAndApparatus(Hospital hospital, Apparatus apparatus) {
        return hospitalApparatusRepository.findByHospitalAndApparatus(hospital,apparatus);
    }

    @Override
    public void save(HospitalApparatus hospitalApparatus) {
        hospitalApparatusRepository.save(hospitalApparatus);
    }
}
