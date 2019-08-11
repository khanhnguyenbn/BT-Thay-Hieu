package com.khanh.excercise1to17;

// convert number from 10 system to 2 system
public class Excercise9 {
	
	static String convert10To2(int n) {
		String output = "";
		while(n > 0) {
			int i = n % 2;
			output = i + output;
			n = n/2;
		}
		
		return output;
	}
	
	public static void main(String[] args) {
		System.out.println(convert10To2(45));
	}

}
