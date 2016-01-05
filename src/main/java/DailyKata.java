import java.math.BigInteger;
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


    static int find(int[] integers) {
        //starting looking from first element, base on even or odd, look for 2nd, and 3rd.
        int sizeOfArr = integers.length;
        int counter = 2;
        boolean firstElementIsEven = integers[0] % 2 == 0;
        if (firstElementIsEven) {
            if (integers[1] % 2 != 0 && integers[2] % 2 == 0) { //2nd element is ood,3rd is even
                return integers[1];
            } else if (integers[1] % 2 != 0 && integers[2] % 2 != 0) { //else 3rd is odd, so return first element
                return integers[0];
            } else {
                //2nd element is even
                while (counter < sizeOfArr) {
                    if (integers[counter] % 2 != 0)
                        return integers[counter];
                    counter++;
                }
                return 0;
            }
        } else { //firstElement is not Even
            if (integers[1] % 2 == 0 && integers[2] % 2 == 0) { //1st element is odd, 2nd element is even,3rd is even
                return integers[0];
            } else if (integers[1] % 2 == 0 && integers[2] % 2 != 0) { //else 3rd is odd, so return 2nd element
                return integers[1];
            } else {
                //2nd elmenet is ood
                while (counter < sizeOfArr) {
                    if (integers[counter] % 2 == 0)
                        return integers[counter];
                    counter++;
                }
                return 0;
            }
        }
    }

    public static String balanceStatements(String lst) {
        String[] orders = lst.split(",");
        Integer sumSell = 0;
        Integer sumBuy = 0;
        int faultyOrders = 0;
        String faultyOrderChain = "";
        for (String order : orders) {

            String[] orderDetail = order.trim().split(" ");
            sumSell += orderDetail[3].toLowerCase().equals("s") ?
                    Integer.parseInt(orderDetail[1]) * (int) (Math.round((Double.parseDouble(orderDetail[2]) * 100) / 100)) : 0;
            sumBuy += orderDetail[3].toLowerCase().equals("b") ?
                    Integer.parseInt(orderDetail[1]) * (int) (Math.round((Double.parseDouble(orderDetail[2]) * 100) / 100)) : 0;
            if (!orderDetail[0].matches("^[ A-z]+$") || !orderDetail[2].contains(".")) {
                faultyOrders++;
                faultyOrderChain += order + ";";
            }
        }
        return "Buy: " + sumBuy + " Sell: " + sumSell + "; Badly formed " + faultyOrders + ": " + faultyOrderChain;
    }

    public static String listSquared(long m, long n) {
        //to find all divisor: m % i == 0
        //the target number range is between m and n
        //if root of (sum of divisor) is a int, then qualify
        Map<Long, Long> map = new HashMap<>();
        for (long i = m; i <= n; i++) {
            //find divisor of i
            long sum = 0l;
            for (long j = 1l; j <= i; j++) {
                if (i % j == 0l) {
                    sum += j * j;
                }
            }
            map.put(i, sum);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            if (Math.sqrt(entry.getValue()) * 2l == entry.getValue()) {
                sb.append("[" + entry.getKey() + ", " + entry.getValue() + "]");
                sb.append(",");
            }
        }
        sb.substring(0, sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public static int indexThatMakeArrayEqual(int[] arr) {
        for (int i = 0; i < arr.length; i++) {  //going through each index
            int j;
            int sumLeft = 0;
            int sumRight = 0;
            for (j = 0; j < i; j++) {
                sumLeft += arr[j];
            }
            for (int x = arr.length - 1; x > j; x--) {
                sumRight += arr[x];
            }
            if (sumLeft == sumRight) return i;
        }
        return -1;
    }

    Set<String> set = new HashSet<>();
    public String learnWord(String input) {
        if (!input.toLowerCase().matches("[a-z]+"))
            return "I do not understand the input";
        String formattedInput = input.toLowerCase();
        int i = set.size();
        set.add(formattedInput);
        if (i == set.size())
            return "I already know the word " + input;
        else
            return "Thank you for teaching me " + input;
    }


    public static void main(String[] args) {

    }

}
