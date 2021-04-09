package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.dto.HospitalCurrentMonthBoughtApparatusesDTO;
import cyborgcpec.hospitalrdm.model.HospitalApparatusBuyingHistory;
import cyborgcpec.hospitalrdm.repository.HospitalApparatusBuyingHistoryRepository;

import cyborgcpec.hospitalrdm.service.HospitalApparatusBuyingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalApparatusBuyingHistoryImpl implements HospitalApparatusBuyingHistoryService {
    @Autowired
    private HospitalApparatusBuyingHistoryRepository hospitalApparatusBuyingHistoryRepository;

    @Value(value ="${spring.datasource.url}")
    String url;

    @Value(value = "${spring.datasource.username}")
    String userName;

    @Value(value = "${spring.datasource.password}")
    String password;

    @Override
    public void save(HospitalApparatusBuyingHistory hospitalApparatusBuyingHistory) {
        hospitalApparatusBuyingHistoryRepository.save(hospitalApparatusBuyingHistory);
    }
    //plain jdbc for performance
    @Override
    public List<HospitalCurrentMonthBoughtApparatusesDTO> getHospitalCurrentMonthBoughtApparatuses(long hospitalId) {
       String query=
               "select a.apparatus_price,habh.bought_quantity from apparatus a " +
                       "left join hospital_apparatus_buying_history habh on a.apparatus_id = habh.apparatus_id "
                       +"and hospital_id="+hospitalId+" and extract(month from bought_at)=extract(month from now())";
       List<HospitalCurrentMonthBoughtApparatusesDTO>result=new ArrayList<>();
       try(Connection connection = DriverManager.getConnection(url,userName,password)){
          try(Statement statement = connection.createStatement()){
              ResultSet resultSet = statement.executeQuery(query);
              while (resultSet.next()) {
                  HospitalCurrentMonthBoughtApparatusesDTO hospitalCurrentMonthBoughtApparatusesDTO = new HospitalCurrentMonthBoughtApparatusesDTO();
                  hospitalCurrentMonthBoughtApparatusesDTO.setApparatusPrice(resultSet.getLong(1));
                  hospitalCurrentMonthBoughtApparatusesDTO.setBoughtQuantity(resultSet.getLong(2));
                  result.add(hospitalCurrentMonthBoughtApparatusesDTO);
              }
          }
       } catch (SQLException throwable) {
           throwable.printStackTrace();
       }
       return result;
    }

}
