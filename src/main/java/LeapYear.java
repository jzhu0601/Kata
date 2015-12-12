

import java.util.*;
import java.util.stream.Collector;

import static java.util.Arrays.sort;

/**
 * Created by jzhu on 12/2/2015.
 */
public class LeapYear {

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0 && !(year % 100 == 0)) {
            return true;
        } else if (year % 400 == 0) {
            return true;
        }
        return false;
    }

    public boolean isValidOpeningBracket(String input) {

        char c = '\u0000';
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                c = input.charAt(i);
                stack.push(c);
            }
            if (input.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else
                    stack.pop();
            }
        }
        return stack.empty();
    }


    public static double paste(int numberOne, int numberTwo) {
        String strResult = ((Integer) numberOne).toString() + "." + ((Integer) numberTwo).toString();
        return Double.parseDouble(strResult);
    }

    public static int countPassengers(ArrayList<int[]> stops) {

        int sum = 0;
        for (int i = 0; i < stops.size(); i++) {

            sum += (stops.get(i)[0] - stops.get(i)[1]);

        }
        return sum;
    }

    public static long findNextSquare(long sq) {
        double base = Math.sqrt(sq);
        if (base != (int) base)
            return -1;
        double newBase = base + 1;
        return (long) Math.pow(newBase, 2);
    }

    public static double twoDecimalPlaces(double number) {
        return (long) (number * 100) / 100.;
    }

    public static boolean hasUniqueChars(String str) {

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        if (set.size() == str.length())
            return true;
        return false;
    }

    public static String longest(String s1, String s2) {
        String combo = s1 + s2;
        char[] comboArr = combo.toCharArray();
        sort(comboArr);
        char[] sortedArr = comboArr;
        Set<Character> sortDupArr = new LinkedHashSet<>();
        for (char aSortedArr : sortedArr) sortDupArr.add(aSortedArr);
        char[] finishedCharArr = new char[sortDupArr.size()];
        int couter = 0;
        for (Character c : sortDupArr) {
            finishedCharArr[couter] = c;
            couter++;
        }
        return new String(finishedCharArr);
    }

    public static double totalCost(int... args) {
        // {2,1,1} --> {1,0,0} --> 3 books
        //{1,0,0} --> {0,0,0} --> 1 book
        int couter = 0;
        double pricePerBook = 8;
        int totalBooks = 0;
        double[] discounts = {1, 0.95, 0.9, 0.8, 0.75};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            list.add(args[i]);
        }
        // list contains 2,1,1  1,0,0
        int counter = 0;
        int markerForZero = 0;
        boolean flag = true;
        while (flag) {
            for (int j = 0; j < list.size(); j++) {
                if (!list.get(j).equals(0)) {
                    markerForZero++;
                    continue;
                }
                list.add(j, list.get(j) - 1);
            }
            counter++;
            if (markerForZero == list.size()) {
                flag = false;
            }
        }

        double totalCost = 0;
        double actualDiscount = discounts[args.length - 1];
        totalCost = totalBooks * pricePerBook * actualDiscount;
        return totalCost;
    }


    static boolean stepThroughWith(String s) {

        char pre = '\u0000';
        char next = '\u0000';
        for (int i = 0; i < s.toLowerCase().length() - 1; i++) {
            pre = s.toLowerCase().charAt(i);
            next = s.toLowerCase().charAt(i + 1);
            if (pre == next) {
                return true;
            }
        }
        return false;
    }

    public static String printerError(String s) {
        // your code
        char[] sArr = s.toCharArray();
        int counter = 0;
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] > 'm')
                counter++;
        }
        return ((Integer) counter).toString() + "/" + s.length();

    }


    public static int gps(int s, double[] x) {

        //speed = (x[i]-x[i-1])/s * 3600
        List<Double> list = new LinkedList<>();
        double speedPerHour = 0;
        for (int i = 0; i < x.length - 1; i++) {
            speedPerHour = (x[i + 1] - x[i]) / s * 3600;
            list.add(speedPerHour);
        }
        Collections.sort(list);
        Double max = Math.floor(list.get(list.size() - 1) * 100 / 100);
        return max.intValue();
    }

    public static long thirt(long n) {

        // 321 --> 1*1 + 2 * 10 + 3 * 9 = 48
        String inputString = ((Long) n).toString();
        boolean flag = true;
        long val = 0;
        long newVal = 0;
        while (flag) {
            val = calculate(inputString);
            newVal = calculate(((Long) val).toString());
            if (val == newVal)
                flag = false;
        }

        return newVal;
    }

    static long calculate(String s) {
        char[] input = s.toCharArray();
        int[] cons = {1, 10, 9, 12, 3, 4};
        int inputLength = input.length;
        long sumVal = 0;
        int counter = 0;
        for (int i = inputLength - 1; i >= 0; i--) {
            if (i >= cons.length) {
                counter = 0;
            }
            sumVal += input[i] * cons[counter];
            counter++;
        }
        return sumVal;
    }

    public static boolean isValid(String idn) {

        if (Character.isDigit(idn.charAt(0))) {
            return false;
        } else {
            for (int i = 0; i < idn.length(); i++) {
                String temp = "" + idn.charAt(i);
                if (!temp.matches("^[a-zA-Z0-9]*$") || !temp.equals("$") || temp.matches("\\s")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String reverseString(String input) {

//        StringBuffer sb = new StringBuffer(input);
//        String newString = sb.reverse().toString();
//
//        return newString;
        //char[] inputCharArr = input.toCharArray();
        char[] resultCharArr = new char[input.length()];
        int counter = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            resultCharArr[counter] = input.charAt(i);
            counter++;
        }
        return new String(resultCharArr);
    }

    //passing an array of numbers, find the number that repeat the most times
    public static int findMostInt(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            Integer count = map.get(i);
            if (count == null) {
                count = 1;
            } else count++;
            map.put(i, count);
        }

        int maxKey = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxKey == 0) maxKey = entry.getKey();
            maxKey = entry.getValue() > map.get(maxKey) ? entry.getKey() : maxKey;
        }

        return maxKey;
    }

    public void loopMap(Map<String, String> map) {

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }
    }

    public static int rowSumOddNumbers(int n) {
        return n * n * n;
    }

    // count characters in string
    public static int count_one_char(String s, char c) {

        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                counter++;
            }
        }
        return counter;
    }


    public static String weatherInfo(int temp) {
        int c = convertToCelsius(temp);
        if (c < 0)
            return (c + " is freezing temperature");
        else
            return (c + " is above freezing temperature");
    }

    public static int convertToCelsius(int temperature) {
        int celsius = (temperature - 32) * (5 / 9);
        return celsius;
    }


    public static double[] barTriang(double[] x, double[] y, double[] z) {
        double xx = Math.round(((x[0] + y[0] + z[0]) / 3) * 10000d) / 10000d;
        double yy = Math.round(((x[1] + y[1] + z[1]) / 3) * 10000d) / 10000d;
        double[] result = new double[2];
        result[0] = xx;
        result[1] = yy;
        return result;
    }

    public static int[] divisibleBy(int[] numbers, long divider) {

        List<Integer> result = new ArrayList<>();


        for (int number : numbers) {
            if (number % divider == 0)
                result.add(number);
        }
        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static int reviewFindingMaxNumInArray(int[] inputArr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : inputArr) {
            Integer count = map.get(i);

            if (count == null) {
                map.put(i, 1);
            } else {
                count++;
                map.put(i, count);
            }
        }
        // -1=5, 3=4, 2=1
        int maxKey = 0;
        int maxVal = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxKey == 0) {
                maxKey = entry.getKey();
            }
            maxKey = entry.getKey() > map.get(maxKey) ? entry.getKey() : maxKey;
            maxVal = Math.max(maxVal, entry.getValue());
        }
        return maxVal;
    }


//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
//        StringBuilder sb = new StringBuilder();
//        String line = br.readLine();
//
//        while (line!=null){
//            sb.append(line);
//            sb.append(System.lineSeparator());
//            line=br.readLine();
//        }
//        String everything =  sb.toString();
//        br.close();
//        System.out.println(everything);
//    }


}
