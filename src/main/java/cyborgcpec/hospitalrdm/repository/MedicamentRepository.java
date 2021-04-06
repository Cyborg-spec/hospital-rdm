package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentRepository extends JpaRepository<Medicament,Long> {
    Medicament findByMedicamentName(String medicamentName);
}
