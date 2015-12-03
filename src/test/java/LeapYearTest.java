import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by jzhu on 12/2/2015.
 */
public class LeapYearTest {

    @Test
    public void leapYearDivisibleByFour(){
        assertTrue(LeapYear.isLeapYear(2016));
    }

    @Test
    public void normalYearsAreNotDivisibleByFour(){
        assertFalse(LeapYear.isLeapYear(3));
    }

    @Test
    public void leapYearNotDivisibleByOneHundred(){
        assertFalse(LeapYear.isLeapYear(1900));
    }

    @Test
    public void leapYearDivisiableByFourHundred(){
        assertTrue(LeapYear.isLeapYear(2000));
    }
}
