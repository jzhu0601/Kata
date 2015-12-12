import javafx.collections.transformation.SortedList;

import java.lang.reflect.Array;
import java.util.*;

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

    public static String[] findAllPermutations(String input) {

        return null;
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
        return input.equals(sb.reverse().toString()) ? true : false;
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
        boolean flag = true;
        char[] firstArr = first.toLowerCase().toCharArray();
        char[] secondArr = second.toLowerCase().toCharArray();
        char[] thirdArr = third.toLowerCase().toCharArray();
        Character[] firstCharacterArr = new Character[firstArr.length];
        Character[] secondCharacterArr = new Character[secondArr.length];

        for (int x = 0; x < firstArr.length; x++) firstCharacterArr[x] = firstArr[x];
        for (int y = 0; y < secondArr.length; y++) secondCharacterArr[y] = secondArr[y];

        List<Character> firstList = Arrays.asList(firstCharacterArr);
        List<Character> secondList = Arrays.asList(secondCharacterArr);

        for (int i = 0; i < thirdArr.length; i++) {
            Character temp = thirdArr[i];
            if ((firstList.contains(temp) && firstList.get(i).compareTo(firstList.get(i + 1)) < 0)
                    || (secondList.contains(temp) && secondList.get(i).compareTo(secondList.get(i + 1)) < 0)) {
                continue;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static int checkIfAStringContainsAnotherString(String first, String second) {
        CharSequence secondSeq = second;
        char[] secondArr = second.toLowerCase().toCharArray();
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


    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};

        int[] arr2 = {2, 4, 6, 8, 10};

        List<Integer> list1 = new ArrayList<>();

        List<Integer> list2 = new ArrayList<>();

        for (Integer i : arr1) list1.add(i);
        for (Integer j : arr2) list2.add(j);

        list1.addAll(list2);
        Collections.sort(list1);
        System.out.println(list1);
    }


}
