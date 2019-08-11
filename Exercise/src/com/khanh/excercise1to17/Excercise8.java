package com.khanh.excercise1to17;

//Convert decimal system to radix system 16
public class Excercise8 {
	
	
	static String convertFrom10To16(int num) {
		String output = "";
		while(num > 0) {
			int a = num % 16;
			output = convert(a) + output;
			num = num / 16;
		}
		
		return output;
	}
	
	//convert value < 16
	static String convert(int a) {
		if(a < 10) {
			return Integer.toString(a);
		}else {
			
			switch(a) {
				case 10:
					return "A";
				case 11:
					return "B";
				case 12:
					return "C";
				case 13:
					return "D";
				case 14:
					return "E";
				case 15:
					return "F";
				default:
					return "";
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(convertFrom10To16(1478));
	}
}
