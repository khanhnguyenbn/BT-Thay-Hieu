package com.khanh.excercise1to17;


// Check a String is symmetry or not
public class Excercise13 {

	static boolean checkSymmetry(String input) {
		
		// check from a first index and from a last index
		// if not equal => false
		for (int i = 0; i < (input.length() / 2); i++) {
			if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
				return false;
			}
//			System.out.println(input.charAt(i) + " " + input.charAt(input.length() - 1 - i));
			
		}
		
		// if all equal => true
		return true;
	}
	
	//test
	public static void main(String[] args) {
		System.out.println(checkSymmetry("abcdcba"));
	}
}
