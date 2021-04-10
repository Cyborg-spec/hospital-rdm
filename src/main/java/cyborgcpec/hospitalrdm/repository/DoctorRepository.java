package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.Doctor;
import cyborgcpec.hospitalrdm.model.DoctorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    @Query(value = "select * from doctor where doctor_type_id=:doctorType",nativeQuery = true)
    Set<Doctor> findByDoctorType(@Param("doctorType") long doctorTypeId);
}
