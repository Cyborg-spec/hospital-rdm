package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.dto.HospitalBoughtApparatusesDTO;
import cyborgcpec.hospitalrdm.model.HospitalApparatusBuyingHistory;
import cyborgcpec.hospitalrdm.repository.HospitalApparatusBuyingHistoryRepository;

import cyborgcpec.hospitalrdm.service.HospitalApparatusBuyingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service

public class HospitalApparatusBuyingHistoryImpl implements HospitalApparatusBuyingHistoryService {
    @Autowired
    private HospitalApparatusBuyingHistoryRepository hospitalApparatusBuyingHistoryRepository;

    @Value(value ="${spring.datasource.url}")
    private String url;

    @Value(value = "${spring.datasource.username}")
    private String userName;

    @Value(value = "${spring.datasource.password}")
    private String password;

    @Override
    public void save(HospitalApparatusBuyingHistory hospitalApparatusBuyingHistory) {
        hospitalApparatusBuyingHistoryRepository.save(hospitalApparatusBuyingHistory);
    }

    @Override
    @Transactional
    public List<HospitalBoughtApparatusesDTO> getHospitalCurrentMonthBoughtApparatuses(long hospitalId) {
       String query=
               "select a.apparatus_price,habh.bought_quantity from apparatus a " +
                       "left join hospital_apparatus_buying_history habh on a.apparatus_id = habh.apparatus_id "
                       +"and hospital_id="+hospitalId+" and extract(month from bought_at)=extract(month from now())";
       return getHospitalBoughtApparatuses(query);
    }

    @Override
    @Transactional
    public List<HospitalBoughtApparatusesDTO> getHospitalCurrentYearBoughtApparatuses(long hospitalId) {
        String query=
                "select a.apparatus_price,habh.bought_quantity from apparatus a " +
                        "left join hospital_apparatus_buying_history habh on a.apparatus_id = habh.apparatus_id "
                        +"and hospital_id="+hospitalId+" and extract(year from bought_at)=extract(year from now())";
        return getHospitalBoughtApparatuses(query);
    }

    @Override
    public List<HospitalBoughtApparatusesDTO> getHospitalFromDateToDateBoughtApparatuses(long hospitalId, String fromDate, String toDate) {
        String query="select a.apparatus_price,habh.bought_quantity from apparatus a"+
                     " left join hospital_apparatus_buying_history habh on a.apparatus_id = habh.apparatus_id"
                     +" and hospital_id="+hospitalId+" and bought_at between "+"'"+fromDate+"'"+" and " +"'"+ toDate+"'";

        return getHospitalBoughtApparatuses(query);
    }

    public List<HospitalBoughtApparatusesDTO> getHospitalBoughtApparatuses(String query){
        List<HospitalBoughtApparatusesDTO>result=new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url,userName,password)){
            try(Statement statement = connection.createStatement()){
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    HospitalBoughtApparatusesDTO hospitalBoughtApparatusesDTO = new HospitalBoughtApparatusesDTO();
                    hospitalBoughtApparatusesDTO.setApparatusPrice(resultSet.getLong(1));
                    hospitalBoughtApparatusesDTO.setBoughtQuantity(resultSet.getLong(2));
                    result.add(hospitalBoughtApparatusesDTO);
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

}
