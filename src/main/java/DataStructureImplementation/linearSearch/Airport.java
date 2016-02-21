package DataStructureImplementation.linearSearch;

import java.util.Collections;

/**
 * Created by Jason on 2/19/16.
 */
public class Airport {
    private String city;
    private String country;
    private String code3;

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCode3() {
        return this.code3;
    }
}

class BinarySearch {

    public String toFindCode(String toFind, Airport[] airports) {

        //0,1,2,3,4,5
        int low = 0;
        int high = airports.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            int compare = toFind.compareTo(airports[mid].getCity());
            if (compare < 0) {
                high = mid -1;
            } else if (compare > 0) {
                low = mid + 1;
            } else {
                return airports[mid].getCode3();
            }
        }

        return null;
    }

}
