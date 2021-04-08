package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.model.Apparatus;
import cyborgcpec.hospitalrdm.repository.ApparatusRepository;
import cyborgcpec.hospitalrdm.service.ApparatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApparatusServiceImpl implements ApparatusService {

    @Autowired
    private ApparatusRepository apparatusRepository;

    @Override
    public Apparatus findByApparatusName(String apparatusName) {
        return apparatusRepository.findByApparatusName(apparatusName);
    }
}
