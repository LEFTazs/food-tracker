package SpringInterface;

import org.springframework.http.HttpStatus;

public class ExceptionStatusCodeAssigner {
    
    public ExceptionStatusCodeAssigner() {
        throw new RuntimeException("Can't construct ExceptionStatusCodeAssigner class!");
    }
    
    public static HttpStatus choose(Exception e) {
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        return statusCode;
    }
    
}
