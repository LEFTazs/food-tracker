package SpringInterface;

import exceptions.*;

public class ExceptionIdAssigner {
    
    public ExceptionIdAssigner() {
        throw new RuntimeException("Can't construct ExceptionIdAssigner class!");
    }
    
    public static int choose(Exception e) {
        if (e instanceof InvalidDateException)
            return 1;
        if (e instanceof SameDateException)
            return 2;
        return 0;
    }

}
