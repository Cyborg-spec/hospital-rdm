package cyborgcpec.hospitalrdm.service;

import cyborgcpec.hospitalrdm.model.Medicament;
import cyborgcpec.hospitalrdm.model.Patient;
import cyborgcpec.hospitalrdm.model.Problem;
import cyborgcpec.hospitalrdm.model.Room;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface PatientService {
    Optional<Patient> findById(long id);
    Patient findByFirstNameAndLastName(String firstName,String lastName);
    void save(Patient patient);
    void delete(Patient patient);
    Set<Patient> findByRoom(Room room);
}
