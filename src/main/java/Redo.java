import java.util.*;

/**
 * Created by Jason on 1/30/16.
 */
public class Redo {

    //print duplicate char of a input string array, for example: programming should print
    public static String printDuplicate(String input) {

        char[] intputArr = input.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : intputArr) {
            Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, ++count);
            }
        }
       StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
               sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }

    public static boolean checkAnagrams(String str1, String str2) {
        char[] str1arr = str1.toCharArray();
        char[] str2arr = str2.toCharArray();
        Arrays.sort(str1arr);
        Arrays.sort(str2arr);
        return Arrays.equals(str1arr,str2arr);
    }

    public static void main(String[] args) {
        System.out.println(printDuplicate("programming"));
    }
}
