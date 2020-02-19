package spring_interface;

import foodtracker.CalendarHistory;
import foodtracker.DayHistory;
import foodtracker.Food;
import foodtracker.SimpleDate;
import io.ebean.Ebean;
import java.util.List;
import org.springframework.http.ResponseEntity;
import persistence.CalendarHistoryServer;

public class Service {
    private CalendarHistory calendarHistory;
    private CalendarHistoryServer server;
        
    public Service(CalendarHistoryServer server) {
        this.server = server;
        loadOrCreateCalendarHistory();
    }
    
    public ResponseEntity<Object> getCalendarDays() {
        try {
            DayHistory[] days = calendarHistory.getAllDays();
            server.save(calendarHistory);
            return ResponseCreator.createOkResponse(days);
        } catch (Exception e) {
            return ResponseCreator.createExceptionResponse(e);
        }
    }
    
    public ResponseEntity<Object> getCalendarDay(int year, int month, int day) {
        try {
            SimpleDate date = new SimpleDate(year, month, day);
            DayHistory result = calendarHistory.getDayHistory(date);
            server.save(calendarHistory);
            return ResponseCreator.createOkResponse(result);
        } catch (Exception e) {
            return ResponseCreator.createExceptionResponse(e);
        }
    }
    
    public ResponseEntity<Object> getAllFoodFromDay(int year, int month, int day) {
        try {
            SimpleDate date = new SimpleDate(year, month, day);
            DayHistory dayHistory = calendarHistory.getDayHistory(date);
            Food[] result = dayHistory.getAllEatenFood();
            server.save(calendarHistory);
            return ResponseCreator.createOkResponse(result);
        } catch (Exception e) {
            return ResponseCreator.createExceptionResponse(e);
        }

    }
    
    public ResponseEntity<Object> addDayToCalendar(SimpleDate newDayDate) {
        try {
            DayHistory dayHistoryToAdd = new DayHistory(newDayDate);
            calendarHistory.addDayHistory(dayHistoryToAdd);
            server.save(calendarHistory);
            return ResponseCreator.createOkResponse();
        } catch (Exception e) {
            return ResponseCreator.createExceptionResponse(e);
        }

    }
    
    public ResponseEntity<Object> addFoodToDay(int year, int month, int day, Food foodToAdd) {
        try {
            SimpleDate date = new SimpleDate(year, month, day);
            DayHistory dayHistory = calendarHistory.getDayHistory(date);
            dayHistory.addEatenFood(foodToAdd);
            server.save(calendarHistory);
            return ResponseCreator.createOkResponse();
        } catch (Exception e) {
            return ResponseCreator.createExceptionResponse(e);
        }

    }
    
    public ResponseEntity<Object> clearAllFromDay(int year, int month, int day) {
        try {
            SimpleDate date = new SimpleDate(year, month, day);
            DayHistory dayHistory = calendarHistory.getDayHistory(date);
            dayHistory.clearAll();
            server.save(calendarHistory);
            return ResponseCreator.createOkResponse();
        } catch (Exception e) {
            return ResponseCreator.createExceptionResponse(e);
        }

    }
    
    public ResponseEntity<Object> clearAll() {
        try {
            calendarHistory.clearAll();
            server.save(calendarHistory);
            return ResponseCreator.createOkResponse();
        } catch (Exception e) {
            return ResponseCreator.createExceptionResponse(e);
        }

    }
    
    
    private void loadOrCreateCalendarHistory() {
        if (server.isEmpty()) {
            calendarHistory = new CalendarHistory();
            server.save(calendarHistory);
        } else {
            CalendarHistory lastEntry = server.getLast();
            calendarHistory = lastEntry;
        }
            
    }
}
