import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jason on 12/10/15.
 */
public class TestJunit {

    @Test(expected = IllegalArgumentException.class)
    public void testGetPowerNumberException(){
        MessageUtil.getPowerNumber(-1);
    }
}
