/**
 * Created by jzhu on 12/2/2015.
 */
public class LeapYear {

    public static boolean isLeapYear(int year) {
        if(year % 4 == 0 && !(year%100==0)){
            return true;
        }else if (year%400==0){
            return true;
        }
        return false;
    }
}
