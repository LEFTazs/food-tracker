package foodtracker;

import exceptions.SameDateException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
public class CalendarHistory {
    @Id @Getter @Setter
    private int id;
    
    @Getter @Setter
    private String owner;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DayHistory> trackedDays = new ArrayList<>();
    
    public void addDayHistory(DayHistory dayHistoryToAdd) {
        SimpleDate newDate = dayHistoryToAdd.getDate();
        if (doesDateAlreadyExists(newDate))
            throw new SameDateException();
        
        trackedDays.add(dayHistoryToAdd);
    }
    
    private boolean doesDateAlreadyExists(SimpleDate dateToCheck) {
        return trackedDays.stream()
                .anyMatch(dayHistory -> 
                        dayHistory.getDate().equals(dateToCheck));
    }
    
    public DayHistory getDayHistory(int id) {
        return trackedDays.get(id);
    }
    
    public DayHistory getDayHistory(SimpleDate date) {
        return trackedDays.stream()
                .filter(day -> day.getDate().equals(date))
                .findFirst()
                .orElseThrow();
    }

    public DayHistory[] getAllDays() {
        DayHistory[] newArray = new DayHistory[trackedDays.size()];
        return trackedDays.toArray(newArray);
    }
    
    public void clearAll() {
        trackedDays.clear();
    }
    
    public int getNumberOfDayHistories() {
        return trackedDays.size();
    }
}
