package FoodTracker;

import exceptions.InvalidDateException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class SimpleDate {
    private int year;
    private int month;
    private int day;
    
    SimpleDate(int year, int month, int day) {
        if (!(isYearValid(year) && isMonthValid(month) && isDayValid(day)))
            throw new InvalidDateException();
        
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    private boolean isYearValid(int year) {
        return year > 1900;
    }
    
    private boolean isMonthValid(int month) {
        return month > 0 && month <= 12;
    }
    
    private boolean isDayValid(int day) {
        return day > 0 && day <= 31;
    }
    
    @Override
    public boolean equals(Object other) {
        if (other instanceof SimpleDate) {
            SimpleDate date = (SimpleDate) other;
            boolean isYearEqual = this.getYear() == date.getYear();
            boolean isMonthEqual = this.getMonth() == date.getMonth();
            boolean isDayEqual = this.getDay() == date.getDay();
            return isYearEqual && isMonthEqual && isDayEqual;
        } else {
            return false;
        }
    }
}
