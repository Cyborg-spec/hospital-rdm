package cyborgcpec.hospitalrdm.exceptions.Room;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RoomExceptionHandler {
    @ExceptionHandler(value = {RoomNotFoundException.class})
    public ResponseEntity<Object> roomNotFoundExceptionHandler(RoomNotFoundException roomNotFoundException){
        RoomException roomException=new RoomException();
        roomException.setInfo(roomNotFoundException.getMessage());
        HttpStatus httpStatus=HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(roomException,httpStatus);
    }
}
