package searchingAlgorithm;

/**
 * Created by Jason on 12/14/15.
 */
public class BinarySearch {

    public static int findTargetNumber(int[] inputArr, int target) {

        int start = 0;
        int end = inputArr.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (target == inputArr[middle]) return middle;
            else if (target < inputArr[middle]) {
                end = middle-1;
            } else {
                start = middle+1;
            }
        }
        return -1;
    }


}
