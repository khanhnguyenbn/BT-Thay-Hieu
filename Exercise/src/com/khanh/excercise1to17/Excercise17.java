package com.khanh.excercise1to17;

// swap 2 number without temp
public class Excercise17 {
	
	public static void main(String[] args) {
		int a = 5;
		int b = 6;
		
		System.out.println("before swap: a = " + a + ", b = " + b );
	
		a = a + b;
		b = a - b;
		b = a - b;
		
		System.out.println("after swap: a = " + a + ", b = " + b );
	}
}
