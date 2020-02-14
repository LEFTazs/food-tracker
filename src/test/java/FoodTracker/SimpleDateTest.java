package FoodTracker;

import exceptions.InvalidDateException;
import org.junit.Test;
import static org.junit.Assert.*;


public class SimpleDateTest {
    
    @Test
    public void testConstructorWithValidDate() {
        SimpleDate simpleDate = new SimpleDate(2019, 3, 6);
    }
    
    @Test(expected = InvalidDateException.class)
    public void testConstructorWithInvalidYear() {
        SimpleDate simpleDate = new SimpleDate(-5, 3, 6);
    }
    
    @Test(expected = InvalidDateException.class)
    public void testConstructorWithInvalidMonth() {
        SimpleDate simpleDate = new SimpleDate(2019, 13, 6);
    }
    
    @Test(expected = InvalidDateException.class)
    public void testConstructorWithInvalidDay() {
        SimpleDate simpleDate = new SimpleDate(2019, 3, 40);
    }
    
    @Test
    public void testGetYear() {
        SimpleDate simpleDate = new SimpleDate(2019, 3, 6);
        int year = simpleDate.getYear();
        assertEquals(2019, year);
    }
    
    @Test
    public void testGetMonth() {
        SimpleDate simpleDate = new SimpleDate(2019, 3, 6);
        int month = simpleDate.getMonth();
        assertEquals(3, month);
    }
    
    @Test
    public void testGetDay() {
        SimpleDate simpleDate = new SimpleDate(2019, 3, 6);
        int day = simpleDate.getDay();
        assertEquals(6, day);
    }
    
    @Test
    public void testEquals() {
        SimpleDate simpleDate1 = new SimpleDate(2019, 3, 6);
        SimpleDate simpleDate2 = new SimpleDate(2019, 3, 6);
        assertEquals(simpleDate1, simpleDate2);
    }
    
    @Test
    public void testNotEquals() {
        SimpleDate simpleDate1 = new SimpleDate(2019, 3, 6);
        SimpleDate simpleDate2 = new SimpleDate(2020, 6, 1);
        assertNotEquals(simpleDate1, simpleDate2);
    }
}
