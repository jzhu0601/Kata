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

    public static List<Integer> findOddTwoNumbers(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : arr) {
            Integer count = map.get(i);
            if (count == null) map.put(i, 1);
            else map.put(i, ++count);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) list.add(entry.getKey());
        }
        return list;
    }

    public static int smallestPositiveNumber(int[] arr){

        List<Integer> pos = new ArrayList<>();
        for(int i =0; i < arr.length; i++){
            if(arr[i]>0) pos.add(arr[i]);
        }
        Collections.sort(pos);
        if(pos.get(0)>1) return 1;
        for(int j=0;j< pos.size();j++){
            if(pos.get(j)+1 != pos.get(j+1))
                return pos.get(j)+1;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, -1, -2};
        // 1,2,3,6,8,15
        System.out.println(smallestPositiveNumber(arr));
    }
}




