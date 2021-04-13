package cyborgcpec.hospitalrdm.repository;

import cyborgcpec.hospitalrdm.model.Patient;
import cyborgcpec.hospitalrdm.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByFirstNameAndLastName(String firstName,String lastName);
    Set<Patient> findByRoom(Room room);
}
