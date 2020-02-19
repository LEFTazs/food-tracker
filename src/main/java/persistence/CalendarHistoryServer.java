package persistence;

import foodtracker.CalendarHistory;
import spring_interface.ConfigProperties;
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
    public CalendarHistory getLast() {
        List<CalendarHistory> found = 
                ebeanServer.find(CalendarHistory.class).findList();
        return found.get(found.size() - 1);
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
