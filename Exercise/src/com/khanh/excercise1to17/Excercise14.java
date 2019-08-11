package com.khanh.excercise1to17;

// sort number array by buble sort using for
public class Excercise14 {

	static void sortByBubleSortUsingFor(int[] input) {

		for (int i = input.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if(input[j] > input[j+1]) {
					int temp = input[j];
					input[j] = input[j+1];
					input[j+1] = temp;
				}
			}
		}
		
		// print all element after sort
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
	
	// test
	public static void main(String[] args) {
		
		// int array and assign value
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
		
		// display array before sorting
		System.out.println("Before");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		
		// display array after sorting
		System.out.println("After");
		sortByBubleSortUsingFor(input);
	}
}
