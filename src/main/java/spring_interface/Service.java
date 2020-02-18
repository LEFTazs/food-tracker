package spring_interface;

import foodtracker.CalendarHistory;
import foodtracker.DayHistory;
import foodtracker.Food;
import foodtracker.SimpleDate;
import io.ebean.Ebean;
import java.util.List;
import org.springframework.http.ResponseEntity;

public class Service {
    private CalendarHistory calendarHistory;
    
    public Service() {
        loadOrCreateCalendarHistory();
    }
    
    public ResponseEntity<Object> getCalendarDays() {
        try {
            DayHistory[] days = calendarHistory.getAllDays();
            updateCalendarHistoryInDatabase();
            return ResponseCreator.createOkResponse(days);
        } catch (Exception e) {
            return ResponseCreator.createExceptionResponse(e);
        }
    }
    
    public ResponseEntity<Object> getCalendarDay(int year, int month, int day) {
        try {
            SimpleDate date = new SimpleDate(year, month, day);
            DayHistory result = calendarHistory.getDayHistory(date);
            updateCalendarHistoryInDatabase();
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
            updateCalendarHistoryInDatabase();
            return ResponseCreator.createOkResponse(result);
        } catch (Exception e) {
            return ResponseCreator.createExceptionResponse(e);
        }

    }
    
    public ResponseEntity<Object> addDayToCalendar(SimpleDate newDayDate) {
        try {
            DayHistory dayHistoryToAdd = new DayHistory(newDayDate);
            calendarHistory.addDayHistory(dayHistoryToAdd);
            updateCalendarHistoryInDatabase();
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
            updateCalendarHistoryInDatabase();
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
            updateCalendarHistoryInDatabase();
            return ResponseCreator.createOkResponse();
        } catch (Exception e) {
            return ResponseCreator.createExceptionResponse(e);
        }

    }
    
    public ResponseEntity<Object> clearAll() {
        try {
            calendarHistory.clearAll();
            updateCalendarHistoryInDatabase();
            return ResponseCreator.createOkResponse();
        } catch (Exception e) {
            return ResponseCreator.createExceptionResponse(e);
        }

    }
    
    
    private void loadOrCreateCalendarHistory() {
        List<CalendarHistory> found = 
                Ebean.find(CalendarHistory.class).findList();
        if (found.isEmpty()) {
            calendarHistory = new CalendarHistory();
            saveCalendarHistoryToDatabase();
        } else {
            CalendarHistory lastEntry = found.get(found.size() - 1);
            calendarHistory = lastEntry;
        }
            
    }
    
    private CalendarHistory saveCalendarHistoryToDatabase() {
        Ebean.save(calendarHistory);
        return calendarHistory;
    }

    private CalendarHistory updateCalendarHistoryInDatabase() {
        Ebean.update(calendarHistory);
        return calendarHistory;
    }
}
