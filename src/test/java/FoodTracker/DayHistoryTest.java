package FoodTracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DayHistoryTest {
    
    private DayHistory dayHistoryToTest;
    private SimpleDate date;
    private Food[] testFoods;
    private final double allowedFloatDifference = 0.01;
    
    @Before
    public void setUp() {
        date = new SimpleDate(2019, 2, 3);
        dayHistoryToTest = new DayHistory(date);
        testFoods = new Food[3];
        testFoods[0] = new Food("alma", 20, 10, 5);
        testFoods[1] = new Food("csoki", 5, 60, 3);
        testFoods[2] = new Food("csoki", 5, 80, 3);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddAndGetEatenFood() {
        dayHistoryToTest.addEatenFood(testFoods[0]);
        dayHistoryToTest.addEatenFood(testFoods[1]);
        
        Food result = dayHistoryToTest.getEatenFood(1);
        
        assertEquals(testFoods[1].getName(), result.getName());
    }

    @Test
    public void testGetFirstFoundEatenFood() {
        dayHistoryToTest.addEatenFood(testFoods[0]);
        dayHistoryToTest.addEatenFood(testFoods[1]);
        dayHistoryToTest.addEatenFood(testFoods[2]);
        String searchName = testFoods[1].getName();
        
        Food result = dayHistoryToTest.getFirstFoundEatenFood(searchName);
        
        assertEquals(searchName, result.getName());
        assertEquals(testFoods[1].getCarbohydratesPer100Gram(), 
                    result.getCarbohydratesPer100Gram(), 
                    allowedFloatDifference);
    }
    
    @Test
    public void testAddAndGetAllEatenFood() {
        dayHistoryToTest.addEatenFood(testFoods[0]);
        dayHistoryToTest.addEatenFood(testFoods[1]);
        
        Food[] result = dayHistoryToTest.getAllEatenFood();
        
        assertEquals(testFoods[0].getName(), result[0].getName());
        assertEquals(testFoods[1].getName(), result[1].getName());
    }

    @Test
    public void testClearAll() {
        dayHistoryToTest.addEatenFood(testFoods[0]);
        dayHistoryToTest.addEatenFood(testFoods[1]);
        dayHistoryToTest.addEatenFood(testFoods[2]);
        
        dayHistoryToTest.clearAll();
        
        assertEquals(0, dayHistoryToTest.getNumberOfFood());
    }
    
    @Test
    public void testGetDate() {
        SimpleDate testDate = dayHistoryToTest.getDate();
        assertEquals(testDate, date);
    }
    
}
