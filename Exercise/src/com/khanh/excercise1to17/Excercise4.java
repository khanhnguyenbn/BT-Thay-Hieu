package com.khanh.excercise1to17;

import java.util.Scanner;

// check a number is positive number or nagative number
public class Excercise4 {
	
	static void checkNumber (int n) {
		if(n > 0) {
			System.out.println("This number is a positive number");
		} else if (n < 0) {
			System.out.println("This number is a negative number");
		} else {
			System.out.println("This number is zero");
		}
	}
	
	
	//test function
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("input value to check: ");
		int i = scanner.nextInt();
		checkNumber(i);
	}
}
