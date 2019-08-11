package com.khanh.excercise1to17;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


// print duplicate characters in a string
public class Excercise11 {

	public static void printDuplicateCharacters(String word) {
        char[] characters = word.toLowerCase().toCharArray();

        // build HashMap with character and number of times they appear in String
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        //if HashMap exit character then increase value of that character + 1
        // if not exit then add this character to HashMap with value = 1
        for (Character ch : characters) {
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }

        // Iterate through HashMap to print all duplicate characters of String
        Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
        System.out.printf("List of duplicate characters in String '%s' %n", word);
        for (Map.Entry<Character, Integer> entry : entrySet) {
        	// if value of a charater > 1 mean it appear and it is is looped
            if (entry.getValue() > 1) {
                System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
            }
        }
    }
	
	// test
	public static void main(String[] args) {
		 printDuplicateCharacters("Anhday Cung khong co"); 
		
	}
}
