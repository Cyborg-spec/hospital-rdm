package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.dto.HospitalApparatusResponseDTO;
import cyborgcpec.hospitalrdm.dto.HospitalBoughtApparatusesDTO;
import cyborgcpec.hospitalrdm.model.Apparatus;
import cyborgcpec.hospitalrdm.model.Hospital;
import cyborgcpec.hospitalrdm.model.HospitalApparatus;
import cyborgcpec.hospitalrdm.repository.HospitalApparatusRepository;
import cyborgcpec.hospitalrdm.service.HospitalApparatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class HospitalApparatusServiceImpl implements HospitalApparatusService {
    @Autowired
    private HospitalApparatusRepository hospitalApparatusRepository;

    @Value(value = "${spring.datasource.url}")
    private String url;

    @Value(value = "${spring.datasource.username}")
    private String userName;

    @Value(value = "${spring.datasource.password}")
    private String password;

    @Override
    @Transactional
    public HospitalApparatus findByHospitalAndApparatus(Hospital hospital, Apparatus apparatus) {
        return hospitalApparatusRepository.findByHospitalAndApparatus(hospital, apparatus);
    }

    @Override
    @Transactional
    public void save(HospitalApparatus hospitalApparatus) {
        hospitalApparatusRepository.save(hospitalApparatus);
    }

    @Override
    @Transactional
    public List<HospitalApparatusResponseDTO> findByHospitalId(long hospitalId) {
        String query = "select a.apparatus_price,a.apparatus_name,ha.quantity from apparatus a" +
                " left join hospital_apparatus ha on a.apparatus_id = ha.apparatus_id" +
                " and hospital_id=" + hospitalId;
        return getHospitalApparatusResponseDTO(query);
    }

    public List<HospitalApparatusResponseDTO> getHospitalApparatusResponseDTO(String query) {
        List<HospitalApparatusResponseDTO> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    HospitalApparatusResponseDTO hospitalApparatusResponseDTO = new HospitalApparatusResponseDTO();
                    hospitalApparatusResponseDTO.setPrice(resultSet.getLong(1));
                    hospitalApparatusResponseDTO.setName(resultSet.getString(2));
                    hospitalApparatusResponseDTO.setQuantity(resultSet.getInt(3));
                    result.add(hospitalApparatusResponseDTO);
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

}
