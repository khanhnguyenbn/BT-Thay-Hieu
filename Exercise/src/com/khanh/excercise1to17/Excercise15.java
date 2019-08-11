package com.khanh.excercise1to17;

// set Bubble Sort algorithm using while
public class Excercise15 {
	
	static void sortByBubbleSortUsingWhile (int[] input) {
		
		int i = input.length - 1;
		while (i > 0) {
			int j = 0;
			while (j < i) {
				if(input[j] > input[j+1]) {
					int temp = input[j];
					input[j] = input[j+1];
					input[j+1] = temp;
				}
				j = j + 1;
			}
			i = i - 1;
		}
		
	}
	
	
	public static void main(String[] args) {
		int[] input = new int[9];
		input[0] = 9;
		input[1] = 5;
		input[2] = 6;
		input[3] = 7;
		input[4] = 2;
		input[5] = 1;
		input[6] = 5;
		input[7] = 4;
		input[8] = 5;
		
		System.out.println("Before");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println("After");
		
		sortByBubbleSortUsingWhile(input);
		
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
}
