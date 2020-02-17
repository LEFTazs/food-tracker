package spring_interface;

import org.springframework.http.HttpStatus;

public class ExceptionStatusCodeAssigner {
    
    private ExceptionStatusCodeAssigner() {
    }
    
    public static HttpStatus choose(Exception e) {
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        return statusCode;
    }
    
}
