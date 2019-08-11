package com.khanh.excercise1to17;

public class Excercise7 {

	// check year is lunarYear or Not
	static boolean checkLunarYear(int year) {
		// if year is not divisible by 4 , it is not lunar year
		if(year % 4 == 0) {
			
			// if year is divisible by 4 but it is not divisible by 100 , it is luna year
			if(year % 100 == 0) {
				
				// if year is divisible by 4, 100 and 400 => it is luna year
				if(year % 400 == 0) {
					
					return true;
					
					// if year is divisible by 4, 100 but it is not divisible by 400 => it is not lunar year
				}else {
					return false;
				}
				
			} else {
				
				return true;
			}
			
		}else {
			
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(checkLunarYear(2001));
	}
}
