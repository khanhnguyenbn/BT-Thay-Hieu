package com.khanh.excercise1to17;


// Reverse charactor in word of the sentence
public class Excercise16 {
	
	static String reverseSentence(String input) {
		
		// get word in sentence
		String[] words = input.split(" ");
		
		// get sentence after reverse character in word
		String output = "";
		for (int i = 0; i < words.length; i++) {
			output = output + " " +  reverseWord(words[i]);
		}
		
		return output;
		
	}
	
	// reverse character in a word
	static String reverseWord(String word) {
		
		String reverse = "";
		for (int i = word.length() - 1; i >= 0; i--) {
			reverse = reverse + word.charAt(i);
		}
		
		return reverse;
	}
	
	//test
	public static void main(String[] args) {
		System.out.println(reverseSentence("Day la chuoi de test"));
	}
	
}
