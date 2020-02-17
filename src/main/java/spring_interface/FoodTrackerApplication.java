package spring_interface;

import persistence.CalendarHistoryServer;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodTrackerApplication {
    
    @Autowired
    private ConfigProperties config;

    public static void main(String[] args) {
        SpringApplication.run(FoodTrackerApplication.class, args);
    }
    
    @PostConstruct
    public void initalizeServer() {
        CalendarHistoryServer server = new CalendarHistoryServer(config);
    }
    
}
