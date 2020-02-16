package FoodTracker;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
public class DayHistory {
    @Id @Getter @Setter
    private int id;

    @Getter @NonNull @Embedded
    private SimpleDate date;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Food> trackedFood = new ArrayList<>();
    
    public DayHistory(SimpleDate date) {
        this.date = date;
    }
    
    public void addEatenFood(Food eatenFood) {
        this.trackedFood.add(eatenFood);
    }
    
    public Food getEatenFood(int id) {
        return this.trackedFood.get(id);
    }
    
    public Food getFirstFoundEatenFood(String name) {
        return this.trackedFood.stream()
                .filter(food -> food.getName().equals(name))
                .findFirst()
                .get();
    }
    
    public Food[] getAllEatenFood() {
        Food[] newArray = new Food[trackedFood.size()];
        return trackedFood.toArray(newArray);
    }
    
    public void clearAll() {
        this.trackedFood.clear();
    }
    
    public int getNumberOfFood() {
        return this.trackedFood.size();
    }
}
