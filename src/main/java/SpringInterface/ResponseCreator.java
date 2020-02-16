package SpringInterface;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseCreator {
    
    public static ResponseEntity<Object> createOkResponse() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public static ResponseEntity<Object> createOkResponse(Object body) {
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
    
    public static ResponseEntity<Object> createExceptionResponse(Exception e) {
        HttpStatus statusCode = ExceptionStatusCodeAssigner.choose(e);
        int id = ExceptionIdAssigner.choose(e);
        return new ResponseEntity<>(id, statusCode);
    }
}
