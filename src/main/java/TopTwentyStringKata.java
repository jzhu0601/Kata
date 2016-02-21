import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jason on 12/10/15.
 */
public class TopTwentyStringKata {

    //print duplicate char of a input string array, for example: programming should print
    public static Character[] printDuplicate(String input) {
        char[] inputArr = input.toLowerCase().toCharArray();

        //create map, map the occurance of each char
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : inputArr) {

            Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, ++count);
            }
        }

        List<Character> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }

        Character[] arr = list.toArray(new Character[list.size()]);

        return arr;

    }

    public static boolean checkAnagrams(String str1, String str2) {
        char[] str11 = str1.toLowerCase().toCharArray();
        char[] str22 = str2.toLowerCase().toCharArray();
        Arrays.sort(str11);
        Arrays.sort(str22);
        return Arrays.equals(str11, str22);
    }

    public static char firstNonRepeatedChar(String input) {
        char[] inputCharArr = input.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (Character c : inputCharArr) {
            Integer count = map.get(c);

            if (count == null) {
                map.put(c, 1);
            } else {
                count++;
                map.put(c, count);
            }
        }
        char result = '\u0000';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }

    public static String reverseRecursively(String str) {

        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }
        return reverseRecursively(str.substring(1)) + str.charAt(0);

    }

    public static boolean stringContainsOnlyDigitsWithRegex(String string) {
        return string.matches("[0-9]+");
    }

    public static boolean stringContainsOnlyDigitsWithoutRegex(String string) {
        char[] strArr = string.toCharArray();
        for (int i = 0; i < strArr.length; i++) {
            Character character = strArr[i];
            if (Character.isLetter(character)) {
                return false;
            }
        }
        return true;
    }

    public static Map<Character, Integer> printAllDuplicateCharacterAndTheirCount(String input) {

        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] inputCharArr = input.toLowerCase().toCharArray();

        for (Character c : inputCharArr) {
            Integer count = map.get(c);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            map.put(c, count);
        }
        Map<Character, Integer> newMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                newMap.put(entry.getKey(), entry.getValue());
            }
        }
        return newMap;
    }

    /*
    Return a map, key is the number of vowels,
    value is the number of consonants
    */
    public static Map<Integer, Integer> countNumberOfVowelsAndConsonants(String input) {

        char[] inputCharArr = input.toLowerCase().toCharArray();

        int countVowels = 0;
        int countConsonants = 0;
        for (int i = 0; i < inputCharArr.length; i++) {
            char finder = inputCharArr[i];
            if (finder == 'a' || finder == 'e' || finder == 'i' || finder == 'o' || finder == 'u')
                countVowels++;
            else
                countConsonants++;
        }
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(countVowels, countConsonants);

        return map;
    }

    public static int countOccurrenceOfGivenCharacter(String input, char character) {
        char[] inputCharArr = input.toLowerCase().toCharArray();
        int counter = 0;
        for (int i = 0; i < inputCharArr.length; i++) {
            char temp = inputCharArr[i];
            if (temp == character)
                counter++;
        }
        return counter;
    }

    public static int stringToInt(String input) {
        int result = Integer.parseInt(input);
        return result;
    }

    public static String replaceEachGivenCharacterToOther(String input) {
        CharSequence space = " ";
        CharSequence unicode = "%20";
        return input.replace(space, unicode);
    }

    public static String reverseWordsInASentence(String sentence) {
        String[] parts = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = parts.length - 1; i >= 0; i--) {
            sb.append(parts[i] + " ");
        }
        return sb.toString().trim();
    }

    public static boolean checkPalindrome(String input) {
        StringBuilder sb = new StringBuilder(input);
        return input.equals(sb.reverse().toString());
    }

    public static String removeDuplicateCharacters(String input) {
        char[] inputArr = input.toCharArray();
        Set<Character> set = new LinkedHashSet<>();
        for (Character c : inputArr) set.add(c);
        List<Character> result = new ArrayList<>();
        for (Character ch : set) result.add(ch);
        char[] resultCharArr = new char[result.size()];
        for (int i = 0; i < result.size(); i++) resultCharArr[i] = result.get(i);
        return new String(resultCharArr);

    }

    public static String removeDuplicateCharactersWithoutUsingSet(String input) {
        char[] inputArr = input.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = inputArr[i];
            if (i == input.indexOf(c)) {
                list.add(c);
            } else {
                continue;
            }
        }
        return null;
    }

    public static boolean isValidShuffleOfTwoString(String first, String second, String third) {
        int ps1, ps2, ps3;
        ps1 = ps2 = ps3 = 0;

        while (ps3 < third.length()) {
            if (ps1 < first.length() && third.charAt(ps3) == first.charAt(ps1))
                ps1++;
            else if (ps2 < second.length() && third.charAt(ps3) == second.charAt(ps2))
                ps2++;
            else
                return false;
            ps3++;
        }
        return true;
    }

    public static int checkIfAStringContainsAnotherString(String first, String second) {
        CharSequence secondSeq = second;
        if (first.contains(secondSeq)) {
            return first.indexOf(secondSeq.charAt(0));
        } else {
            return -1;
        }
    }

    public static char highestOccurredCharacterInAString(String input) {
        char[] inputArr = input.toLowerCase().toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (Character c : inputArr) {
            Integer count = map.get(c);
            if (count == null) {
                count = 1;
                map.put(c, count);
            } else {
                count++;
                map.put(c, count);
            }
        }
        char maxNumChar = '\u0000';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (maxNumChar == '\u0000') maxNumChar = entry.getKey();
            if (entry.getValue() > map.get(maxNumChar)) {
                maxNumChar = entry.getKey();
            }
        }
        return maxNumChar;
    }

    public static String removeGivenCharactersFromString(String input, char ch) {
        CharSequence charSequence = "" + ch;
        return input.replace(charSequence, "");
    }

    public static String[] sortStringOnTheirLength(String[] input) {

        Map<Integer, String> map = new TreeMap<>();

        for (String temp : input) map.put(temp.length(), temp);

        List<String> list = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            list.add(entry.getValue());
        }

        return list.toArray(new String[list.size()]);
    }

    public static boolean checkIfSubstringcontain(String input, String substr) {
        CharSequence charSequence = substr;

        return input.contains(charSequence);
    }


    public static String accum(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.toUpperCase().charAt(i));
            for (int j = 0; j < i; j++)
                sb.append(s.toLowerCase().charAt(i));
            sb.append('-');
        }
        sb.setLength(Math.max(sb.length() - 1, 0));
        return sb.toString();
    }


    public static int mxdiflg(String[] a1, String[] a2) {
        if (a1.length == 0 || a2.length == 0) return -1;
        int[] a1Result = minAndMax(a1);
        int[] a2Result = minAndMax(a2);
        return Math.max(a1Result[0] - a2Result[1], a2Result[0] - a1Result[1]);

    }

    public static int[] minAndMax(String[] input) {
        int max = 0;
        int min = 0;
        for (String x : input) {
            max = Math.max(max, x.length());
            if (min == 0) min = x.length();
            min = Math.min(min, x.length());
        }
        int[] result = {max, min};
        return result;
    }

    public static double twoDecimalPlacesNotRounding(double number) {
        String numStr = "";
        String[] parts = new String[2];
        double dubResult = 0;
        if (number > 0) {
            numStr = ((Double) number).toString();
            parts = numStr.replace(".", "-").split("-");
            String result = parts[0] + "." + parts[1].substring(0, 2);
            dubResult = Double.parseDouble(result);
        } else {
            numStr = ((Double) Math.abs(number)).toString();
            parts = numStr.replace(".", "-").split("-");
            String result = "-" + parts[0] + "." + parts[1].substring(0, 2);
            dubResult = Double.parseDouble(result);
        }
        return dubResult;
    }

    public static String longest(String s1, String s2) {

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        List<Character> list = new ArrayList<>();
        for (Character c : s1Arr) list.add(c);
        for (Character c : s2Arr) list.add(c);
        Character[] resultArr = list.toArray(new Character[list.size()]);
        Arrays.sort(resultArr);
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < resultArr.length; i++) {
            set.add(resultArr[i]);
        }
        StringBuffer sb = new StringBuffer();
        for (Character c : set) sb.append(c);
        return sb.toString();
    }

    public static int gps(int s, double[] x) {

        if (s <= 1) return 0;
        if (x.length == 0) return -1;

        final int SEC_TO_HOUR = 3600;
        List<Double> result = new ArrayList<>();

        for (int i = 0; i < x.length - 1; i++) {
            Double speed = (x[i + 1] - x[i]) * SEC_TO_HOUR / s;
            result.add(speed);
        }

        Double[] resultArr = result.toArray(new Double[result.size()]);
        Arrays.sort(resultArr);

        int max = (int) Math.floor(resultArr[resultArr.length - 1]);
        return max;
    }

    public static int GetSum(int a, int b) {
        int sumVal = 0;
        if (a == b) return a;
        else if (a < b) {
            for (int i = a; i <= b; i++) {
                sumVal += i;
            }
        } else {
            for (int j = b; j <= a; j++) {
                sumVal += j;
            }
        }
        return sumVal;
    }

    public static int movie(int card, int ticket, double perc) {

        int times = 1;
        int totalCostBuyTicket = 0;
        double actualPerc = 0;
        double totalCostBuyCard = 0;
        int cardCost = 0;
        while (cardCost >= totalCostBuyTicket) {
            totalCostBuyTicket = ticket * times;
            actualPerc = Math.pow(perc, times);
            totalCostBuyCard = card + ticket * actualPerc;
            cardCost = (int) Math.round(totalCostBuyCard);
            times++;
        }
        return times;
    }

    private static Map<String, String> dictionary = new HashMap<>();

    public static String makeBackronym(String acronym) {
        char[] acronymArr = acronym.toUpperCase().toCharArray();
        String result = "";
        for (char c : acronymArr) {
            result += dictionary.get("" + c) + " ";
        }
        return result.substring(0, result.length() - 1);
    }

    //    SeriesSum(1) => 1 = "1"
    //    SeriesSum(2) => 1 + 1/4 = "1.25"
    //    SeriesSum(5) => 1 + 1/4 + 1/7 + 1/10 + 1/13 = "1.57"
    public static String seriesSum(int n) {
        double increment = 0d;
        double sum = 0d;
        for (int i = 1; i <= n; i++) {
            sum += 1 / (1 + increment);
            increment += 3d;
        }
        return "" + (Math.round(sum * 100d)) / 100d;
    }

    public static boolean validate(final String eanCode) {

        char[] eanArr = eanCode.toCharArray();
        int sum = 0;
        for (int i = 0; i < eanArr.length - 1; i += 2) {
            sum += Integer.parseInt("" + eanArr[i]) * 1 + Integer.parseInt("" + eanArr[i + 1]) * 3;
        }
        int mod = 10 - (sum % 10);
        if (mod == 10) mod = 0;
        if (Integer.parseInt("" + eanArr[eanArr.length - 1]) == mod)
            return true;
        else
            return false;
    }

    //when n = 11;
    //1110987654321
    //111098765432
    //11109876543
    //1110987654
    //111098765
    //11109876
    //1110987
    //111098
    //11109
    //1110
    //11
    public static String pattern(int n) {
        if (n < 1) return "";
        String finalPattern = "";
        List<String> patternList = new ArrayList<>();
        int conter = n;
        while (conter > 0) {
            String pattern = "";
            for (int i = n; i > n - conter; i--) {
                pattern += ("" + (i));
            }
            patternList.add(pattern);
            conter--;
        }
        for (String c : patternList) finalPattern += c + "\n";
        return finalPattern.toString().substring(0, finalPattern.length() - 1);
    }

    public static int factorial(int n) {
        if (n < 0 || n > 12) throw new IllegalArgumentException();
        else {
            int sum = 1;
            for (int i = n; i >= 1; i--) {
                sum *= i;
            }
            return sum;
        }
    }

    public static String getQuote(String[] quotes, String hero) {

        String heroName = "";
        switch (hero.substring(0, 3).toLowerCase()) {
            case "bat":
                heroName = "Batman";
                break;
            case "rob":
                heroName = "Robin";
                break;
            case "jok":
                heroName = "Joker";
                break;
        }
        int index = 0;
        String restOfStr = hero.substring(3);
        for (char c : restOfStr.toCharArray()) {
            String find = "" + c;
            if (find.matches("\\d")) {
                index = Integer.parseInt(find);
            }
        }

        return heroName + ": " + quotes[index];
    }

    public static String makeComplement(String dna) {
        StringBuilder sb = new StringBuilder();
        for (char c : dna.toUpperCase().toCharArray()) {
            String cc = "" + c;
            switch (cc) {
                case "A":
                    sb.append("T");
                    break;
                case "T":
                    sb.append("A");
                    break;
                case "C":
                    sb.append("G");
                    break;
                case "G":
                    sb.append("C");
                    break;
            }
        }
        return sb.toString();
    }

    public static long conjecture(long x) {
        List<Long> list = new ArrayList<>();
        while (x > 1) {
            if (x % 2 == 0) {
                x /= 2;
            } else {
                x = x * 3 + 1;
            }
            list.add(x);
        }
        if (x == 1l) list.add(x);
        return list.size();
    }

    public static int mystery(String s) {
        char[] letters = s.toCharArray();
        int x = 0;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == ' ') {
                letters[i] = '_';
                x++;
            }
        }
        System.out.println(s);
        return x;
    }

    public static String funReverse(String s) {
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        String arr = sb.toString();
        int counter = 0;
        for (int i = 1; i < s.length() - 2; i++) {
            // arr.replace();
        }
        return null;
    }

    private static String text;

    public static List<String> getTokens(String pattern) {
        ArrayList<String> tokens = new ArrayList<>();
        Pattern tokSplitter = Pattern.compile(pattern);
        Matcher m = tokSplitter.matcher(text);

        while (m.find()) {
            tokens.add(m.group());
        }

        return tokens;
    }


    public static int power(int i) {
        if (i == 0) {
            return 1;
        } else {
            return 2 * power(i - 1); // why we decrease with 1 and how the recursion works here
        }
    }

    public static String getSubStringWithUnique(String s) {
        Set<Character> set = new LinkedHashSet<>();
        char[] ch = s.toCharArray();
        for (Character c : ch) {
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : set) {
            sb.append(c);
        }

        return sb.toString();
    }

    public String sortGiftCode(String code) {
        Set<Character> set = new TreeSet<>();
        for (char c : code.toCharArray()) {
            set.add(c);
        }
        List<Character> arr = new ArrayList<>();
        for (char c : set) {
            arr.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : arr) sb.append(c);
        return sb.toString();
    }


    public static int loneSum(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();

        for (Integer i : arr) {
            Integer count = map.get(i);
            if (count == null) {
                map.put(i, 1);
            } else {
                map.put(i, ++count);
            }
        }
        System.out.println(map);
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 1)
                continue;
            sum += entry.getKey();
        }
        return sum;
    }

    static int counter;

    public static int count8(int n) {
        if (n == 0) return 0;

        if (n % 10 == 8) {
            if (n / 10 % 10 == 8) return 2 + count8(n / 10);
            return 1 + count8(n / 10);
        } else {
            return count8(n / 10);
        }
    }

    public static int countX(String str) {
        if (str.length() == 0) return 0;
        if (str.charAt(str.length() - 1) == 'x') {
            return 1 + countX(str.substring(0, str.length() - 1));
        }
        return countX(str.substring(0, str.length() - 1));
    }

    public static int countHi(String str) {
        if (str.length() == 0) {
            return 0;
        }

        if (str.charAt(str.length() - 1) == 'i' && str.length() > 1) {
            if (str.charAt(str.length() - 2) == 'h') {
                return 1 + countHi(str.substring(0, str.length() - 1));
            }
        }
        return countHi(str.substring(0, str.length() - 1));
    }

    public String changeXY(String str) {
        if (str.length() == 0) return str;

        if (str.charAt(0) == 'x') {
            return "y" + changeXY(str.substring(1));
        } else {
            return str.charAt(0) + changeXY(str.substring(1));
        }
    }

    public static int centeredAverage(int[] nums) {
        if (nums.length % 2 != 0)
            return nums[(nums.length) / 2];
        return 0;
    }

    public static int sum67(int[] nums) {
        int sum = 0;
        boolean sixMode = false;
        for (int i = 0; i < nums.length; i++) {
            if (sixMode) {
                if (nums[i] == 7)
                    sixMode = false;
            } else if (nums[i] == 6)
                sixMode = true;
            else
                sum += nums[i];
        }
        return sum;
    }

    public static String frontTimes(String str, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (str.length() < 3) {
                sb.append(str);
            } else {
                sb.append(str.substring(0, 3));
            }

        }
        return sb.toString();
    }

    public static String doubleChar(String str) {
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            sb.append("" + c + c);
        }
        return sb.toString();
    }

    public static String plusOut(String str, String word) {
        int pos = str.indexOf(word);
        StringBuilder sb = new StringBuilder(str.length());
        while (pos != -1) {
            for (int i = 0; i < pos; i++)
                sb.append("+");
            sb.append(word);
            str = str.substring(pos + word.length());
            pos = str.indexOf(word);
        }
        for (char c : str.toCharArray()) {
            sb.append("+");
        }
        return sb.toString();
    }

    public static String wordEnds(String str, String word) {
        int pos = str.indexOf(word);
        StringBuilder sb = new StringBuilder();
        while (pos != -1) {
            if (pos > 0)
                sb.append(str.charAt(pos - 1));
            if (pos + word.length() < str.length())
                sb.append(str.charAt(pos + word.length()));
            pos = str.indexOf(word, pos + word.length());
        }
        return sb.toString();
    }

    public static boolean xyzThere(String str) {
        CharSequence charSequence = "xyz";
        if (!str.contains(charSequence))
            return false;
        else {
            int pos = str.indexOf("xyz");
            while (pos != -1) {
                if (pos == 0)
                    return true;
                else if (!("" + str.charAt(pos - 1)).equals(".")) {
                    return true;
                }
                str = str.substring(pos + 3);
                pos = str.indexOf("xyz");
            }
            return false;
        }
    }


    public static boolean xyBalance(String str) {
        Stack<Character> stack = new Stack<>();
        for (Character c : str.toCharArray()) {
            if (c == 'x') stack.push(c);
            if (c == 'y') stack.clear();
        }
        return stack.empty();
    }

    public static boolean xyBalanceWithoutCollection(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == 'x') sb.append(c);
            if (c == 'y') sb.append(c);
        }
        String result = sb.toString();

        if (result.length() > 0 && result.substring(result.length() - 1).equals("y")) return true;
        if (result.length() == 0) return true;
        return false;
    }

    public int noTeenSum(int a, int b, int c) {
        int sum = 0;
        a = fixTeen(a);
        b = fixTeen(b);
        c = fixTeen(c);
        return a + b + c;
    }

    public int fixTeen(int n) {
        if (13 <= n && n <= 19) {
            if (n == 15 || n == 16) {
                return n;
            } else
                return 0;
        } else {
            return n;
        }
    }

    public static void main(String[] args) {

    }

}
