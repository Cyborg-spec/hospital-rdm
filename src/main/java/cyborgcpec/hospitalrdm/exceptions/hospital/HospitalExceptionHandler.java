package cyborgcpec.hospitalrdm.exceptions.hospital;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HospitalExceptionHandler {
    @ExceptionHandler(value = HospitalNotFoundException.class)
    public ResponseEntity<Object> hospitalNotFoundExceptionHandler(HospitalNotFoundException hospitalNotFoundException){
        HospitalException hospitalException=new HospitalException();
        hospitalException.setInfo(hospitalNotFoundException.getMessage());
        HttpStatus httpStatus=HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(hospitalException,httpStatus);
    }
}
