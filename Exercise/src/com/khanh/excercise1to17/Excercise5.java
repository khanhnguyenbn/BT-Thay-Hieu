package com.khanh.excercise1to17;

// reverse a String
public class Excercise5 {
	
	static String reverseString(String before) {
		// init reverse is ""
		String reverse = "";
		
		// get elements of String from last index to first index
		for (int i = before.length() - 1; i >= 0; i--) {
			reverse = reverse + before.charAt(i);
		}
		
		return reverse;
	}
	
	// test
	public static void main(String[] args) {
		System.out.println(reverseString("abcdefgh"));
	}

}
