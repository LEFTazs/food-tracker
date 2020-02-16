package Persistence;

import FoodTracker.CalendarHistory;
import SpringInterface.ConfigProperties;

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
    public void delete(CalendarHistory bean) {
        ebeanServer.delete(bean);
    }

}
