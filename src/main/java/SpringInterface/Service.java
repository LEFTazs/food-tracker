package SpringInterface;

import FoodTracker.CalendarHistory;
import FoodTracker.DayHistory;
import FoodTracker.Food;
import FoodTracker.SimpleDate;
import org.springframework.http.ResponseEntity;

public class Service {
    private CalendarHistory calendarHistory;
    
    public Service() {
        calendarHistory = new CalendarHistory();
    }
    
    public ResponseEntity<Object> getCalendarDays() {
        try {
            DayHistory[] days = calendarHistory.getAllDays();
            return ResponseCreator.createOkResponse(days);
        } catch (Exception e) {
            return ResponseCreator.createExceptionResponse(e);
        }
    }
    
    public ResponseEntity<Object> getCalendarDay(int year, int month, int day) {
        try {
            SimpleDate date = new SimpleDate(year, month, day);
            DayHistory result = calendarHistory.getDayHistory(date);
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
            return ResponseCreator.createOkResponse(result);
        } catch (Exception e) {
            return ResponseCreator.createExceptionResponse(e);
        }

    }
    
    public ResponseEntity<Object> addDayToCalendar(SimpleDate newDayDate) {
        try {
            DayHistory dayHistoryToAdd = new DayHistory(newDayDate);
            calendarHistory.addDayHistory(dayHistoryToAdd);
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
            return ResponseCreator.createOkResponse();
        } catch (Exception e) {
            return ResponseCreator.createExceptionResponse(e);
        }

    }
    
    public ResponseEntity<Object> clearAll() {
        try {
            calendarHistory.clearAll();
            return ResponseCreator.createOkResponse();
        } catch (Exception e) {
            return ResponseCreator.createExceptionResponse(e);
        }

    }
    
}
