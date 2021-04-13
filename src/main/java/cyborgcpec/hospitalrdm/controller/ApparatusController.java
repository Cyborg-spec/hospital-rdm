package cyborgcpec.hospitalrdm.controller;

import cyborgcpec.hospitalrdm.dto.ApparatusDTO;
import cyborgcpec.hospitalrdm.dto.NewApparatusRequestDTO;
import cyborgcpec.hospitalrdm.model.Apparatus;
import cyborgcpec.hospitalrdm.service.ApparatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApparatusController {
    @Autowired
    private ApparatusService apparatusService;

    @PostMapping("apparatus/new-apparatus")
    public NewApparatusRequestDTO newApparatus(@RequestBody NewApparatusRequestDTO newApparatusRequestDTO){
        //TODO check new apparatus given data
        Apparatus apparatus=new Apparatus();
        apparatus.setApparatusName(newApparatusRequestDTO.getApparatusName());
        apparatus.setApparatusPrice(newApparatusRequestDTO.getApparatusPrice());
        apparatus.setApparatusPricePerHour(newApparatusRequestDTO.getApparatusPricePerHour());
        apparatusService.save(apparatus);
        return newApparatusRequestDTO;
    }
}
