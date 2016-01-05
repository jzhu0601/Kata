import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jason on 12/30/15.
 */
public class DailyKataTest {

    DailyKata dailyKata = new DailyKata();
    @Test
    public void simpleTest() {
        assertEquals("Thank you for teaching me hello", dailyKata.learnWord("hello"));
        assertEquals("Thank you for teaching me world", dailyKata.learnWord("world"));
        assertEquals("Thank you for teaching me goodbye", dailyKata.learnWord("goodbye"));
        assertEquals("I already know the word world", dailyKata.learnWord("world"));
        assertEquals("I already know the word World", dailyKata.learnWord("World"));
    }
}