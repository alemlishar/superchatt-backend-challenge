package challenge_superchat.dk.exceptions;


import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomException extends ResponseEntityExceptionHandler {

	@Value(value = "${data.exception.message1}")
    private String message1;
    @Value(value = "${data.exception.message2}")
    private String message2;
    @Value(value = "${data.exception.message3}")
    private String message3;
    
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity blogNotFoundException(ResourceNotFoundException ResourceNotFoundException) {
       return new ResponseEntity<String>(message2, HttpStatus.NOT_FOUND);
   }
    
    
   // @ExceptionHandler(value = Exception.class)
  //  public ResponseEntity<Object> databaseConnectionFailsException(Exception exception) {
 //       return new ResponseEntity<>(message3, HttpStatus.INTERNAL_SERVER_ERROR);
//   }

}



