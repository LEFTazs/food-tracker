package data_transfer_objects;

import foodtracker.Food;

public class Converter {
    private Converter() { 
    }
    
    public static Food foodFromDTO(FoodDTO foodDTO) {
        String name = foodDTO.getName();
        float carbohydrates = foodDTO.getCarbohydratesPer100Gram();
        float fat = foodDTO.getFatPer100Gram();
        float protein = foodDTO.getProteinPer100Gram();
        return new Food(name, protein, carbohydrates, fat);
    }
}
