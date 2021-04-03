package cyborgcpec.hospitalrdm.exceptions.doctor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DoctorExceptionHandler {
    @ExceptionHandler(value = {DoctorNotFoundException.class})
    public ResponseEntity<Object> doctorNotFoundExceptionHandler(DoctorNotFoundException doctorNotFoundException){
        DoctorException doctorException=new DoctorException();
        doctorException.setInfo(doctorNotFoundException.getMessage());
        HttpStatus status=HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(doctorException,status);
    }
}
