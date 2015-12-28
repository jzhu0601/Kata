import org.junit.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.CheckedInputStream;

import static org.junit.Assert.*;

/**
 * Created by Jason on 12/10/15.
 */
public class TopTwentyStringKataTest {

    @org.junit.Test
    public void testPrintDuplicate() throws Exception {

    }

    @Test
    public void testCheckAnagrams() throws Exception {

    }

    @Test
    public void testFirstNonRepeatedChar() throws Exception {

    }

    @Test
    public void testReverseRecursively() throws Exception {

    }

    @Test
    public void testStringContainsOnlyDigitsWithRegex() throws Exception {

    }

    @Test
    public void testStringContainsOnlyDigitsWithoutRegex() throws Exception {

    }

    @Test
    public void testPrintAllDuplicateCharacterAndTheirCount() throws Exception {
        String input = "Programming";
        final Map<Character, Integer> expected = new LinkedHashMap<Character, Integer>() {
            {
                put('r', 2);
                put('g', 2);
                put('m', 2);
            }
        };
        assertEquals(expected, TopTwentyStringKata.printAllDuplicateCharacterAndTheirCount(input));
    }

    @Test
    public void testCountNumberOfVowelsAndConsonants() {
        String input = "December";
        final Map<Integer, Integer> expected = new LinkedHashMap<Integer, Integer>() {
            {
                put(new Integer(3), new Integer(5));
            }
        };
        assertEquals(expected, TopTwentyStringKata.countNumberOfVowelsAndConsonants(input));
    }

    @Test
    public void testCountOccurrenceOfGivenCharacter() {
        String string = "JavaScript";
        assertEquals(2, TopTwentyStringKata.countOccurrenceOfGivenCharacter(string, 'a'));
    }

    @Test
    public void testStringToInt() {
        assertEquals(123, TopTwentyStringKata.stringToInt("123"));
    }

    @Test
    public void testReplaceEachGivenCharacterToOther() {
        assertEquals("Java%20is%20Great", TopTwentyStringKata.replaceEachGivenCharacterToOther("Java is Great"));
    }


    @Test
    public void testReverseWordsInASentence() {
        assertEquals("language programming best is Java",
                TopTwentyStringKata.reverseWordsInASentence("Java is best programming language"));
    }

    @Test
    public void testCheckPalindrome(){
        assertEquals(true,TopTwentyStringKata.checkPalindrome("radar"));
        assertEquals(true,TopTwentyStringKata.checkPalindrome("madam"));
    }

    @Test
    public void testRemoveDuplicateCharacters(){
        assertEquals("mon",TopTwentyStringKata.removeDuplicateCharacters("moon"));
        assertEquals("bans",TopTwentyStringKata.removeDuplicateCharacters("bananas"));
    }

    @Test
    public void testIsValidShuffleOfTwoString(){
        assertEquals(true,TopTwentyStringKata.isValidShuffleOfTwoString("abc","def","dabecf"));
    }

    @Test
    public void testCheckIfAStringContainsAnotherString(){
        assertEquals(2,TopTwentyStringKata.checkIfAStringContainsAnotherString("I love Java","love"));
    }

    @Test
    public void testHighestOccurredCharacterInAString(){
        assertEquals('a',TopTwentyStringKata.highestOccurredCharacterInAString("aaaaaaaaaaaaaaaaabbbbcddddeeeeee"));
    }

    @Test
    public void testRemoveGivenCharactersFromString(){
        assertEquals("Jaon",TopTwentyStringKata.removeGivenCharactersFromString("Jason",'s'));
    }

    @Test
    public void testSortStringOnTheirLength(){
        String[] input = new String[]{"jason","a","json","son"};
        String[] expected = new String[]{"a","son","json","jason"};
        assertArrayEquals(expected,TopTwentyStringKata.sortStringOnTheirLength(input));
    }

    @Test
    public void testFunReverse(){
        String given = "012345";
        String expected = "504132";
        assertEquals(expected,TopTwentyStringKata.funReverse(given));
    }
}