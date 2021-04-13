package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.dto.HospitalBoughtApparatusesDTO;
import cyborgcpec.hospitalrdm.dto.PatientUsedMedicamentDTO;
import cyborgcpec.hospitalrdm.model.Patient;
import cyborgcpec.hospitalrdm.model.PatientMedicament;
import cyborgcpec.hospitalrdm.repository.PatientMedicamentRepository;
import cyborgcpec.hospitalrdm.service.PatientMedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PatientMedicamentServiceImpl implements PatientMedicamentService {
    @Autowired
    private PatientMedicamentRepository patientMedicamentRepository;

    @Value(value = "${spring.datasource.url}")
    private String url;

    @Value(value = "${spring.datasource.username}")
    private String userName;

    @Value(value = "${spring.datasource.password}")
    private String password;

    @Override
    @Transactional
    public void save(PatientMedicament patientMedicament) {
        patientMedicamentRepository.save(patientMedicament);
    }

    @Override
    @Transactional
    public Set<PatientMedicament> findByPatient(Patient patient) {
        return patientMedicamentRepository.findByPatient(patient);
    }

    @Override
    public List<PatientUsedMedicamentDTO> getPatientUsedMedicamentByPatientId(long id) {
        String query="select m.medicament_name,pa.used_quantity,m.medicament_price from patient_medicament pa " +
                "left join medicament m on pa.medicament_id = m.medicament_id and patient_id="+id;
        return getPatientUsedMedicament(query);
    }

    public List<PatientUsedMedicamentDTO> getPatientUsedMedicament(String query){
        List<PatientUsedMedicamentDTO>result=new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url,userName,password)){
            try(Statement statement = connection.createStatement()){
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    PatientUsedMedicamentDTO patientUsedMedicamentDTO = new PatientUsedMedicamentDTO();
                    patientUsedMedicamentDTO.setMedicamentName(resultSet.getString(1));
                    patientUsedMedicamentDTO.setUsedQuantity(resultSet.getInt(2));
                    patientUsedMedicamentDTO.setMedicamentPrice(BigDecimal.valueOf(resultSet.getLong(3)));
                    result.add(patientUsedMedicamentDTO);
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
