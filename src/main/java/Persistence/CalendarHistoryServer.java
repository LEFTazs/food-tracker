package Persistence;

import FoodTracker.CalendarHistory;

public class CalendarHistoryServer extends ObjectServer<CalendarHistory> {

    public CalendarHistoryServer(String driver, String url, String username, String password, String migrationFile) {
        super(driver, url, username, password, migrationFile);
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
