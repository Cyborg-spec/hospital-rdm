package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.model.Doctor;
import cyborgcpec.hospitalrdm.model.DoctorType;
import cyborgcpec.hospitalrdm.repository.DoctorRepository;
import cyborgcpec.hospitalrdm.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    @Transactional
    public Set<Doctor> findByDoctorType(long doctorTypeId) {
        return doctorRepository.findByDoctorType(doctorTypeId);
    }

    @Override
    @Transactional
    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
    }
}
