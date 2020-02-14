package FoodTracker;

import exceptions.SameDateException;
import java.util.ArrayList;
import java.util.List;

public class CalendarHistory {
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
