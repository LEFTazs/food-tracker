package FoodTracker;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Food {
    @Id
    private int id;
    
    @NonNull 
    private String name;
    private float proteinPer100Gram;
    private float carbohydratesPer100Gram;
    private float fatPer100Gram;
    
    public Food(String name, float proteinPer100Gram, 
            float carbohydratesPer100Gram, float fatPer100Gram) {
        this.name = name;
        this.proteinPer100Gram = proteinPer100Gram;
        this.carbohydratesPer100Gram = carbohydratesPer100Gram;
        this.fatPer100Gram = fatPer100Gram;
    }
}
