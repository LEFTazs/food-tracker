package FoodTracker;

import exceptions.SameDateException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalendarHistoryTest {
    
    CalendarHistory calendarHistoryToTest;
    DayHistory[] dayHistory;
        
    @Before
    public void setUp() {
        calendarHistoryToTest = new CalendarHistory();
        dayHistory = new DayHistory[2];
        dayHistory[0] = new DayHistory(new SimpleDate(2011, 3, 5));
        dayHistory[1] = new DayHistory(new SimpleDate(2011, 3, 6));
    }
    
    @Test
    public void testAddAndGetDayHistory() {
        calendarHistoryToTest.addDayHistory(dayHistory[0]);
        calendarHistoryToTest.addDayHistory(dayHistory[1]);
        
        DayHistory result = calendarHistoryToTest.getDayHistory(1);
        
        assertEquals(dayHistory[1].getDate(), result.getDate());
    }
    
    @Test(expected = SameDateException.class)
    public void testAddDayHistoryException() {
        calendarHistoryToTest.addDayHistory(dayHistory[0]);
        calendarHistoryToTest.addDayHistory(dayHistory[0]);
    }
    
    @Test
    public void testGetNumberOfDayHistories() {
        calendarHistoryToTest.addDayHistory(dayHistory[0]);
        calendarHistoryToTest.addDayHistory(dayHistory[1]);
        
        int size = calendarHistoryToTest.getNumberOfDayHistories();
        
        assertEquals(size, 2);
    }
    
    @Test
    public void testClearAll() {
        calendarHistoryToTest.addDayHistory(dayHistory[0]);
        calendarHistoryToTest.addDayHistory(dayHistory[1]);
        
        calendarHistoryToTest.clearAll();
        
        int size = calendarHistoryToTest.getNumberOfDayHistories();
        assertEquals(size, 0);
    }
}