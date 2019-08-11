package com.khanh.excercise1to17;

// get average number of array
public class Excercise1 {

	// test function
	public static void main(String[] args) {
		// init array include 5 elements
		int[] list = new int[5];
		
		// assign for each element
		list[0] = 1;
		list[1] = 2;
		list[2] = 3;
		list[3] = 4;
		list[4] = 5;
		
		// display average number
		System.out.println(averageArray(list));
			
	}
	
	
	public static double averageArray(int[] list) {
		
		//init sum of elements in array = 0
		int sum = 0;
		//get each element in array
		for (int i = 0; i < list.length; i++) {
			// plus to sum
			sum = sum + list[i];
		}
		
		// return average number
		return (double) sum/list.length;
	}
	

}
