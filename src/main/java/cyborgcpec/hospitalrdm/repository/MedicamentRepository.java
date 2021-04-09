package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface MedicamentRepository extends JpaRepository<Medicament,Long> {
    Medicament findByMedicamentName(String medicamentName);
    @Query(value = "select * from medicament where medicament_name in :medicamentNames",nativeQuery = true)
    Set<Medicament> findByMedicamentNames(@Param("medicamentNames") Set<String>medicamentNames);
    @Query(value = "select * from medicament m left join patient_medicament pm on m.medicament_id = pm.medicament_id and pm.patient_id=:patientId"
            ,nativeQuery = true)
    Set<Medicament> findByPatientId(@Param("patientId")long patientId);
}
