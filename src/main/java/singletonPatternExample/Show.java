package singletonPatternExample;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jason on 12/14/15.
 */
public class Show {

    //create static variable to store single instance
    private static final Show INSTANCE = new Show();

    private Set<String> availableSeats;

    //this is for caller to get the instance
    public static Show getInstance(){
        return INSTANCE;
    }

    //constructor is private, so no caller can instantiate the object direclty
    private Show(){
        availableSeats = new HashSet<>();
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    public boolean bookSeat(String seat){
        return availableSeats.remove(seat);
    }

    public static void ticketAgentBook(String seat){
        Show show = Show.getInstance();
        System.out.println(show.bookSeat(seat));
    }



}
