package cyborgcpec.hospitalrdm.service;

import cyborgcpec.hospitalrdm.model.Apparatus;
import cyborgcpec.hospitalrdm.model.Hospital;
import cyborgcpec.hospitalrdm.model.HospitalApparatus;

public interface HospitalApparatusService {
    HospitalApparatus findByHospitalAndApparatus(Hospital hospital, Apparatus apparatus);
    void save(HospitalApparatus hospitalApparatus);
}
