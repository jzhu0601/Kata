import java.util.*;

/**
 * Created by Jason on 12/30/15.
 */
public class DailyKata {

    public static boolean validateWord(String word) {
        Map<Character, Integer> map = new HashMap<>();
        char[] wordArr = word.toLowerCase().toCharArray();
        for (Character c : wordArr) {
            Integer num = map.get(c);
            if (num == null) {
                map.put(c, 1);
            } else {
                map.put(c, ++num);
            }
        }
        Integer temp = map.get(wordArr[0]);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (temp != entry.getValue()) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        validateWord("abcbac");
    }

}
