package foodtracker;

import foodtracker.Food;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FoodTest {

    private Food foodToTest;
    private final double allowedFloatDifference = 0.01;
    
    @Before
    public void setUp() {
        foodToTest = new Food("apple", 1, 20.5F, 5);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetName() {
        String expResult = "apple";
        String result = foodToTest.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetProteinPer100Gram() {
        float expResult = 1F;
        float result = foodToTest.getProteinPer100Gram();
        assertEquals(expResult, result, allowedFloatDifference);
    }

    @Test
    public void testGetCarbohydratesPer100Gram() {
        float expResult = 20.5F;
        float result = foodToTest.getCarbohydratesPer100Gram();
        assertEquals(expResult, result, allowedFloatDifference);
    }

    @Test
    public void testGetFatPer100Gram() {
        float expResult = 5F;
        float result = foodToTest.getFatPer100Gram();
        assertEquals(expResult, result, allowedFloatDifference);
    }

    @Test
    public void testSetName() {
        String newName = "egg";
        foodToTest.setName(newName);
        String result = foodToTest.getName();
        assertEquals(newName, result);
    }

    @Test
    public void testSetProteinPer100Gram() {
        float newValue = 30;
        foodToTest.setProteinPer100Gram(newValue);
        float result = foodToTest.getProteinPer100Gram();
        assertEquals(newValue, result, allowedFloatDifference);
    }

    @Test
    public void testSetCarbohydratesPer100Gram() {
        float newValue = 30;
        foodToTest.setCarbohydratesPer100Gram(newValue);
        float result = foodToTest.getCarbohydratesPer100Gram();
        assertEquals(newValue, result, allowedFloatDifference);
    }

    @Test
    public void testSetFatPer100Gram() {
        float newValue = 30;
        foodToTest.setFatPer100Gram(newValue);
        float result = foodToTest.getFatPer100Gram();
        assertEquals(newValue, result, allowedFloatDifference);
    }
    
}
