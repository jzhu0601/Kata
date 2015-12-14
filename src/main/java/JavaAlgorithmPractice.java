import java.util.*;

/**
 * Created by Jason on 12/12/15.
 */
public class JavaAlgorithmPractice {

    public static int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (Integer i : arr1) list1.add(i);
        for (Integer j : arr2) list1.add(j);
        list1.addAll(list2);
        Collections.sort(list1);
        Integer[] integerArr = list1.toArray(new Integer[list1.size()]);
        int[] resultArr = new int[integerArr.length];
        for (int x = 0; x < resultArr.length; x++) resultArr[x] = integerArr[x];
        return resultArr;
    }

    public static ArrayList<String> merge(String[] words, String[] more) {

        ArrayList<String> sentence = new ArrayList<String>();

        for (String w : words) sentence.add(w);

        for (String w : more) sentence.add(w);

        return sentence;

    }


    public static void main(String[] args) {
        int[] arr1 = {2, 5, 6, 9};
        int[] arr2 = {1, 2, 3, 29};
        String[] words = {"my","name","is","jason"};
        String[] more = {"what","is","your","name"};
        System.out.println(merge(words,more));
    }
}




