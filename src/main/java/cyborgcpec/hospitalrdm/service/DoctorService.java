package cyborgcpec.hospitalrdm.service;

import cyborgcpec.hospitalrdm.model.Doctor;
import cyborgcpec.hospitalrdm.model.DoctorType;

import java.util.Set;

public interface DoctorService {
    Set<Doctor> findByDoctorType(DoctorType type);
    void save(Doctor doctor);
}
