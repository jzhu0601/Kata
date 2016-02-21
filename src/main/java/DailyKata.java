import com.jasonzhu.reflection.Apple;

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

    public static String totalLicks(Map<String, Integer> env) {
        if (env.size() == 0) return "It took 252 licks to get to the tootsie roll center of a tootsie pop.";
        final int AVG_LICK = 252;
        Map.Entry<String, Integer> maxEntry = null;
        int sumDef = 0;
        for (Map.Entry<String, Integer> entry : env.entrySet()) {
            sumDef += entry.getValue();
            if (maxEntry == null)
                maxEntry = entry;
            maxEntry = maxEntry.getValue() > entry.getValue() ? maxEntry : entry;
        }
        int finalLick = AVG_LICK + sumDef;
        if (maxEntry.getValue() > 0)
            return "It took " + finalLick + " licks to get to the tootsie roll center of a tootsie pop. The toughest challenge was " + maxEntry.getKey() + ".";
        else
            return "It took " + finalLick + " licks to get to the tootsie roll center of a tootsie pop.";
    }


    public static int sumDigits(int n) {
        if (n < 10)
            return n;
        return sumDigits(n / 10) + n % 10;
    }

    public boolean cigarParty(int cigars, boolean isWeekend) {
        if (isWeekend) {
            if (cigars >= 40) return true;
        } else {
            if (cigars >= 40 && cigars <= 60)
                return true;
        }
        return false;
    }

    public static int[] race(int v1, int v2, int g) {
        int totalSecondsTaken = 0;
        if (v2 > v1) {
            totalSecondsTaken = (g * 3600) / (v2 - v1);
        } else {
            return null;
        }
        return new int[]{totalSecondsTaken / 3600, (totalSecondsTaken % 3600) / 60, totalSecondsTaken % 60};
    }

    public static boolean makeBricks(int small, int big, int goal) {
        if (big * 5 > goal) {
            if ((big * 5) % (goal - small) == 0 || (big * 5) - (goal - small) == 5)
                return true;
            return false;
        }

        if (big * 5 == goal) {
            return true;
        } else {
            // big*5 < goal
            if (goal - big * 5 <= small)
                return true;
        }
        return false;
    }

    public static int countYZ(String str) {
        String[] parts = str.toLowerCase().split("\\P{Alpha}+");
        int count = 0;
        for (String string : parts) {
            if (string.equals("")) continue;
            char target = string.charAt(string.length() - 1);
            if (target == 'y' || target == 'z') count++;
        }
        return count;
    }

    public static String withoutString(String base, String remove) {
        CharSequence toRemove = remove.toLowerCase();
        String result = base.toLowerCase().replace(toRemove, "");
        return result;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 10, 2, 4, 8, 1};
        System.out.println(maxDifference(a));
    }

    static String[] missingWords(String s, String t) {
        if (t.length() < 1 || s.length() > 1_000_000) return new String[]{""};
        List<String> sList = new ArrayList<>(Arrays.asList(s.split(" ")));
        List<String> tList = Arrays.asList(t.split(" "));
        sList.removeAll(tList);
        return sList.toArray(new String[sList.size()]);
    }

    static int maxDifference(int[] a) {
        if (a.length < 1 || a.length > 1_000_000) return -1;
        int[] oldArr = Arrays.copyOf(a, a.length);
        Arrays.sort(a);
        int max = a[a.length - 1];
        if (max > 1_000_000 || a[0] < -1_000_000) return -1;
        int min = max;
        for (int i = 0; i < oldArr.length; i++) {
            if (oldArr[i] < max) min = Math.min(min, oldArr[i]);
            if (oldArr[i] == max) break;
        }
        return min == max ? -1 : max - min;
    }




}
