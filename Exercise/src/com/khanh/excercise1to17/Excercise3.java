package com.khanh.excercise1to17;

public class Excercise3 {
	// Print N_First prime number
	static void printNFirstPrime(int n) {
		
		int check = 0;
		for (int i = 2; ; i++) {
			if(checkPrime(i)) {
				check++;
				System.out.println(i);
				if (check == n) {
					break;
				}
			}
			
		}
		

	}

	// check a number is Prime or Not
	static boolean checkPrime(int n) {
		// if n < 2 is not prime number
		if (n <= 1) {
			return false;
		} else {
			for (int i = 2; i < (int) Math.sqrt(n); i++) {
				if (n % i == 0) {
					return false;
				} else {
					continue;
				}
			}
		}

		return true;

	}
	
	//test function
	public static void main(String[] args) {
		printNFirstPrime(10);
	}
}
