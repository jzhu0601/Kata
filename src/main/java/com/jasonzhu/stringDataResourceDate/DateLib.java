package com.jasonzhu.stringDataResourceDate;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jason on 1/26/16.
 */
public class DateLib {

    Calendar cal = Calendar.getInstance();

    //Milliseconds equal to how many years?
    public static Date trillionMillisecondsToYears() {
        return new Date(1_000_000_000_000L);
    }

    public static void main(String[] args) {
        System.out.println(trillionMillisecondsToYears().toString());
    }
}
