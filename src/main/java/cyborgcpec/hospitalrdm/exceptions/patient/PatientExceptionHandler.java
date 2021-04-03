package cyborgcpec.hospitalrdm.exceptions.patient;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PatientExceptionHandler {
    @ExceptionHandler(value = {PatientNotFoundException.class})
    public ResponseEntity<Object> patientNotFoundExceptionHandler(PatientNotFoundException patientNotFoundException){
        PatientException patientException=new PatientException();
        patientException.setInfo(patientNotFoundException.getMessage());
        HttpStatus httpStatus=HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(patientException,httpStatus);
    }
}
