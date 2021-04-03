package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.model.Doctor;
import cyborgcpec.hospitalrdm.model.DoctorType;
import cyborgcpec.hospitalrdm.repository.DoctorRepository;
import cyborgcpec.hospitalrdm.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Set<Doctor> findByDoctorType(DoctorType type) {
        return doctorRepository.findByDoctorType(type);
    }
}
