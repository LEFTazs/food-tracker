package SpringInterface;

import FoodTracker.CalendarHistory;
import FoodTracker.DayHistory;
import FoodTracker.Food;
import FoodTracker.SimpleDate;

public class Service {
    private CalendarHistory calendarHistory;
    
    public Service() {
        calendarHistory = new CalendarHistory();
    }
    
    public DayHistory[] getCalendarDays() {
        return calendarHistory.getAllDays();
    }
    
    public DayHistory getCalendarDay(int year, int month, int day) {
        SimpleDate date = new SimpleDate(year, month, day);
        return calendarHistory.getDayHistory(date);
    }
    
    public Food[] getAllFoodFromDay(int year, int month, int day) {
        DayHistory dayHistory = getCalendarDay(year, month, day);
        return dayHistory.getAllEatenFood();
    }
    
    public void addDayToCalendar(SimpleDate newDayDate) {
        DayHistory dayHistoryToAdd = new DayHistory(newDayDate);
        calendarHistory.addDayHistory(dayHistoryToAdd);
    }
    
    public void addFoodToDay(int year, int month, int day, Food foodToAdd) {
        DayHistory dayHistory = getCalendarDay(year, month, day);
        dayHistory.addEatenFood(foodToAdd);
    }
    
    public void clearAllFromDay(int year, int month, int day) {
        DayHistory dayHistory = getCalendarDay(year, month, day);
        dayHistory.clearAll();
    }
    
    public void clearAll() {
        calendarHistory.clearAll();
    }
    
}
