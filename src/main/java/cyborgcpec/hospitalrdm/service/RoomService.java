package cyborgcpec.hospitalrdm.service;

import cyborgcpec.hospitalrdm.model.Doctor;
import cyborgcpec.hospitalrdm.model.Room;

public interface RoomService {
    Room findByDoctor(Doctor doctor);
}
