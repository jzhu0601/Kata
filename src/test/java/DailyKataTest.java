import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void testTotalLicks() {
        Map<String, Integer> env = new HashMap<>(2, 1f);
        env.put("freezing temps", 10);
        env.put("clear skies", -2);
        assertEquals("It took 260 licks to get to the tootsie roll center of a tootsie pop. The toughest challenge was freezing temps.", DailyKata.totalLicks(env));
        assertEquals("It took 252 licks to get to the tootsie roll center of a tootsie pop.", DailyKata.totalLicks(new HashMap<>(0)));
    }


}