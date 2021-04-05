package cyborgcpec.hospitalrdm.exceptions.Problem;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProblemExceptionHandler {
    @ExceptionHandler(value = {ProblemTypeNotFoundException.class})
    public ResponseEntity<Object> problemTypeNotFoundExceptionHandler(ProblemTypeNotFoundException problemTypeNotFoundException){
        ProblemException problemException=new ProblemException();
        problemException.setInfo(problemTypeNotFoundException.getMessage());
        HttpStatus httpStatus=HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(problemException,httpStatus);
    }
}
