package Persistence;

import FoodTracker.CalendarHistory;

public class CalendarHistoryServer extends ObjectServer<CalendarHistory> {

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
