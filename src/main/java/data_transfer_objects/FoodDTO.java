package data_transfer_objects;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class FoodDTO {    
    @NonNull 
    private String name;
    private float proteinPer100Gram;
    private float carbohydratesPer100Gram;
    private float fatPer100Gram;
}
