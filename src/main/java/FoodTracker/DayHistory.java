package FoodTracker;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DayHistory {
    @Getter @NonNull private SimpleDate date;
    private List<Food> trackedFood = new ArrayList<>();
    
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
    
    public void clearAll() {
        this.trackedFood.clear();
    }
    
    public int getNumberOfFood() {
        return this.trackedFood.size();
    }
}
