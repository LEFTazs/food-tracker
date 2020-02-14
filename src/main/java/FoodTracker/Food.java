package FoodTracker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Food {
    @NonNull private String name;
    private float proteinPer100Gram;
    private float carbohydratesPer100Gram;
    private float fatPer100Gram;
}
