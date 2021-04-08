package cyborgcpec.hospitalrdm.service;

import cyborgcpec.hospitalrdm.model.Apparatus;

public interface ApparatusService {
    Apparatus findByApparatusName(String apparatusName);
}
