package FoodTracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FoodTrackerController {
    
    private CalendarHistory calendarHistory;
    
    public FoodTrackerController() {
        calendarHistory = new CalendarHistory();
    }
    
    @GetMapping("/calendar")
    public DayHistory[] getCalendar() {
        return calendarHistory.getAllDays();
    }
}
