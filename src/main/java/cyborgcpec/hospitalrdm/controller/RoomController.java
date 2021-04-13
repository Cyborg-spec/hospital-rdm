package cyborgcpec.hospitalrdm.controller;

import cyborgcpec.hospitalrdm.dto.ResponsePatientDTO;
import cyborgcpec.hospitalrdm.exceptions.Room.RoomNotFoundException;
import cyborgcpec.hospitalrdm.mappers.EntityToDTOConverter;
import cyborgcpec.hospitalrdm.model.Patient;
import cyborgcpec.hospitalrdm.model.Room;
import cyborgcpec.hospitalrdm.service.PatientService;
import cyborgcpec.hospitalrdm.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.GeneratedValue;
import java.util.Optional;
import java.util.Set;

@RestController
public class RoomController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private EntityToDTOConverter entityToDTOConverter;

    @GetMapping("room/{id}/patients")
    public Set<ResponsePatientDTO> getRoomPatients(@PathVariable long id) throws RoomNotFoundException {
        Optional<Room> room=roomService.findById(id);
        if(room.isPresent()){
            Set<Patient>patients=patientService.findByRoom(room.get());
            return entityToDTOConverter.patientToPatientDTO(patients);
        }else {
            throw new RoomNotFoundException("Room not found");
        }
    }
}
