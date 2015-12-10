import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jzhu on 12/2/2015.
 */
public class LeapYearTest {

    @Test
    public void leapYearDivisibleByFour() {
        assertTrue(LeapYear.isLeapYear(2016));
    }

    @Test
    public void normalYearsAreNotDivisibleByFour() {
        assertFalse(LeapYear.isLeapYear(3));
    }

    @Test
    public void leapYearNotDivisibleByOneHundred() {
        assertFalse(LeapYear.isLeapYear(1900));
    }

    @Test
    public void leapYearDivisiableByFourHundred() {
        assertTrue(LeapYear.isLeapYear(2000));
    }

    @Test
    public void simpleTests() {
        assertTrue(LeapYear.hasUniqueChars(""));
        assertTrue(LeapYear.hasUniqueChars("abc"));
        assertFalse(LeapYear.hasUniqueChars("a b c"));
    }


    @Test
    public void testLongest() {
        System.out.println("longest Fixed Tests");
        assertEquals("aehrsty", LeapYear.longest("aretheyhere", "yestheyarehere"));
        assertEquals("abcdefghilnoprstu", LeapYear.longest("loopingisfunbutdangerous", "lessdangerousthancoding"));
        assertEquals("acefghilmnoprstuy", LeapYear.longest("inmanylanguages", "theresapairoffunctions"));
    }

    @Test
    public void testBasics(){
        assertEquals(8,LeapYear.totalCost(1),0.00);
        assertEquals(16,LeapYear.totalCost(2),0.00);
        assertEquals(15.2,LeapYear.totalCost(1,1),0.00);
        assertEquals(21.6,LeapYear.totalCost(1,1,1),0.00);
    }

    @Test
    public void testBuyingMoreThanOneBookInDifferentCatagory(){
        assertEquals(23.2,LeapYear.totalCost(1,2),0.00);
    }

    @Test
    public void testGreenGlassDoor(){
        assertEquals(true,LeapYear.stepThroughWith("Loop"));
    }

    @Test
    public void testPrinterFunc(){
        assertEquals("0/14", LeapYear.printerError("aaabbbbhaijjjm"));
        assertEquals("3/56", LeapYear.printerError("aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz"));
    }

    @Test
    public void testThrit(){
        assertEquals(48,LeapYear.thirt(321));
    }

    @Test
    public void testSumOddNumber(){
        assertEquals(1,LeapYear.rowSumOddNumbers(1));
        assertEquals(8,LeapYear.rowSumOddNumbers(2));

    }

    @Test
    public void testCountingCharacters(){
        assertEquals(2,LeapYear.count_one_char("moon",'o'));

    }








}
