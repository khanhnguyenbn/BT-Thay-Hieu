package com.khanh.excercise1to17;

// Generate random number
public class Excercise12 {
	
	
	// generate random
	static int randomNum() {
		int a = (int) (Integer.MAX_VALUE * Math.random());
		return a;
	}
	
	//test
	public static void main(String[] args) {
		System.out.println(randomNum());
	}
}
