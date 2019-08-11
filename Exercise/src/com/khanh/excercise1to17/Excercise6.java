package com.khanh.excercise1to17;

public class Excercise6 {
	// get a reverse number of a number
	static int reverseNumber(int before) {
		
		int after = 0;
		while(before > 0) {
			//get the last index number of before
			int a = before % 10;
			
			// inserted last index number of before to after variable
			after = after * 10 + a;
			
			// and continue
			before = before / 10;
		}
		
		return after;
	}
	
	public static void main(String[] args) {
		System.out.println(reverseNumber(1205));
	}

}
