package cyborgcpec.hospitalrdm.service;

import cyborgcpec.hospitalrdm.model.Apparatus;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ApparatusService {
    Apparatus findByApparatusName(String apparatusName);
    Set<Apparatus> findByPatientId(long patientId);
    void save(Apparatus apparatus);
}
