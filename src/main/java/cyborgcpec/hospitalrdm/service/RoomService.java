package cyborgcpec.hospitalrdm.service;

import cyborgcpec.hospitalrdm.model.Doctor;
import cyborgcpec.hospitalrdm.model.Room;

import java.util.Optional;

public interface RoomService {
    Room findByDoctor(Doctor doctor);
    Optional<Room>findById(long id);
}
