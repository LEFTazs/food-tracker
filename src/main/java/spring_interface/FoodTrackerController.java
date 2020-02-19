package spring_interface;

import data_transfer_objects.Converter;
import data_transfer_objects.FoodDTO;
import foodtracker.Food;
import foodtracker.SimpleDate;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import persistence.CalendarHistoryServer;


@RestController
public class FoodTrackerController {
    
    private Service service = null;
    
    @Autowired
    private ConfigProperties config;
        
    @PostConstruct
    public void initalizeServiceWithServer() {
        CalendarHistoryServer server = new CalendarHistoryServer(config);
        server.updateSchema();
        server.initialize();
        service = new Service(server);
    }
    
    
    @GetMapping("/calendar")
    public ResponseEntity<Object> getCalendar() {
        return service.getCalendarDays();
    }
    
    @GetMapping("/calendar/{year}/{month}/{day}")
    public ResponseEntity<Object> getCalendarDay(@PathVariable int year, 
                                     @PathVariable int month, 
                                     @PathVariable int day) {
        return service.getCalendarDay(year, month, day);
    }
    
    @GetMapping("/calendar/{year}/{month}/{day}/foods")
    public ResponseEntity<Object> getCalendarDayFoods(@PathVariable int year, 
                                      @PathVariable int month, 
                                      @PathVariable int day) {
        return service.getAllFoodFromDay(year, month, day);
    }
    
    @PostMapping("/calendar/newday")
    public ResponseEntity<Object> addDayToCalendar(@RequestBody SimpleDate newDayDate) {
        return service.addDayToCalendar(newDayDate);
    }
    
    @PostMapping("/calendar/{year}/{month}/{day}/newfood")
    public ResponseEntity<Object> addFoodToDay(@PathVariable int year, 
                             @PathVariable int month, 
                             @PathVariable int day,
                             @RequestBody FoodDTO newFood) {
        Food food = Converter.foodFromDTO(newFood);
        return service.addFoodToDay(year, month, day, food);
    }
    
    @DeleteMapping("/calendar")
    public ResponseEntity<Object> clearAll() {
        return service.clearAll();
    }
    
    @DeleteMapping("/calendar/{year}/{month}/{day}")
    public ResponseEntity<Object> clearAllFromDay(@PathVariable int year, 
                                @PathVariable int month, 
                                @PathVariable int day) {
        return service.clearAllFromDay(year, month, day);
    }
}
