package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.Apparatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ApparatusRepository extends JpaRepository<Apparatus,Long> {
    Apparatus findByApparatusName(String apparatusName);
    @Query(value = "select a.apparatus_price,a.apparatus_name,a.apparatus_id,a.apparatus_price_per_hour from patient_apparatus pa" +
            " left join apparatus a on a.apparatus_id = pa.apparatus_id" +
            " and patient_id=:patientId",nativeQuery = true)
    Set<Apparatus>findByPatientId(@Param("patientId")long patientId);
}
