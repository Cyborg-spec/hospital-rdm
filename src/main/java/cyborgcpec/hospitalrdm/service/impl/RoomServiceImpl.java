package cyborgcpec.hospitalrdm.service.impl;

import cyborgcpec.hospitalrdm.model.Doctor;
import cyborgcpec.hospitalrdm.model.Room;
import cyborgcpec.hospitalrdm.repository.RoomRepository;
import cyborgcpec.hospitalrdm.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room findByDoctor(Doctor doctor) {
        return roomRepository.findByDoctor(doctor);
    }
}
