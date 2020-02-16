package Persistence;

import FoodTracker.CalendarHistory;
import SpringInterface.ConfigProperties;
import java.util.List;

public class CalendarHistoryServer extends ObjectServer<CalendarHistory> {

    public CalendarHistoryServer(ConfigProperties configProperties) {
        super(configProperties);
    }

    @Override
    public void save(CalendarHistory bean) {
        ebeanServer.save(bean);
    }

    @Override
    public CalendarHistory get(int id) {
        return ebeanServer.find(CalendarHistory.class, id);
    }
    
    @Override
    public boolean isEmpty() {
        List<CalendarHistory> found = 
                ebeanServer.find(CalendarHistory.class).findList();
        return found.isEmpty();
    }

    @Override
    public void delete(CalendarHistory bean) {
        ebeanServer.delete(bean);
    }

}
