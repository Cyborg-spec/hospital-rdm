package cyborgcpec.hospitalrdm.exceptions.medicament;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MedicamentExceptionHandler {
    @ExceptionHandler(value = {MedicamentNotFoundException.class})
    public ResponseEntity<Object> medicamentNotFoundExceptionHandler(MedicamentNotFoundException medicamentNotFoundException){
        MedicamentException medicamentException=new MedicamentException();
        medicamentException.setInfo(medicamentNotFoundException.getMessage());
        HttpStatus httpStatus=HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(medicamentException,httpStatus);
    }
}
