package SpringInterface;

import FoodTracker.CalendarHistory;
import FoodTracker.DayHistory;
import FoodTracker.Food;
import FoodTracker.SimpleDate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FoodTrackerController {
    
    private Service service;
    
    public FoodTrackerController() {
        service = new Service();
    }
    
    @GetMapping("/calendar")
    public DayHistory[] getCalendar() {
        return service.getCalendarDays();
    }
    
    @GetMapping("/calendar/{year}/{month}/{day}")
    public DayHistory getCalendarDay(@PathVariable int year, 
                                     @PathVariable int month, 
                                     @PathVariable int day) {
        return service.getCalendarDay(year, month, day);
    }
    
    @GetMapping("/calendar/{year}/{month}/{day}/foods")
    public Food[] getCalendarDayFoods(@PathVariable int year, 
                                      @PathVariable int month, 
                                      @PathVariable int day) {
        return service.getAllFoodFromDay(year, month, day);
    }
    
    @PostMapping("/calendar/newday")
    public void addDayToCalendar(@RequestBody SimpleDate newDayDate) {
        service.addDayToCalendar(newDayDate);
    }
    
    @PostMapping("/calendar/{year}/{month}/{day}/newfood")
    public void addFoodToDay(@PathVariable int year, 
                             @PathVariable int month, 
                             @PathVariable int day,
                             @RequestBody Food newFood) {
        service.addFoodToDay(year, month, day, newFood);
    }
    
    @DeleteMapping("/calendar")
    public void clearAll() {
        service.clearAll();
    }
    
    @DeleteMapping("/calendar/{year}/{month}/{day}")
    public void clearAllFromDay(@PathVariable int year, 
                                @PathVariable int month, 
                                @PathVariable int day) {
        service.clearAllFromDay(year, month, day);
    }
}
