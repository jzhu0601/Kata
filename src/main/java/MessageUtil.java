/**
 * Created by Jason on 12/10/15.
 */
public class MessageUtil {


    public static int getPowerNumber(int number) {

        if(number<=0) throw new IllegalArgumentException("Not valid number");
        return number * number;

    }
}
