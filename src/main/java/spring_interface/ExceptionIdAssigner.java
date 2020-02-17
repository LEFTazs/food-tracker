package spring_interface;

import exceptions.*;

public class ExceptionIdAssigner {
    
    private ExceptionIdAssigner() {
    }
    
    public static int choose(Exception e) {
        if (e instanceof InvalidDateException)
            return 1;
        if (e instanceof SameDateException)
            return 2;
        return 0;
    }

}
