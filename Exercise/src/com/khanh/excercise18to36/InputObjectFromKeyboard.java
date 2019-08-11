package com.khanh.excercise18to36;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputObjectFromKeyboard {

	// input subject information and return a subject object
	public static Subject inputSubject() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input subject name: ");
		String subjectName = scanner.nextLine();
		System.out.println("Input start date with format dd-MM-yyyy");
		String inputStartDate = scanner.nextLine();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = format.parse(inputStartDate);
			System.out.println("Input end date with format dd-MM-yyyy");
			String inputEndDate = scanner.nextLine();
			endDate = format.parse(inputEndDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Subject(subjectName, startDate, endDate);
		
	}
	
	// input information of student from keyboard and return that student 
	public static Student inputStudent() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input first name of student");
		String firstName = scanner.nextLine();
		System.out.println("Input last name of student");
		String lastName = scanner.nextLine();
		System.out.println("Input date of birth with format dd-MM-yyyy");
		String inputDate = scanner.nextLine();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date dateOfBirth = null;
		try {
			dateOfBirth = format.parse(inputDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Input place that student live");
		String place = scanner.nextLine();
		
		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setDateOfBirth(dateOfBirth);
		student.setPlaceToLive(place);
		
		return student;
		
		
	}
	
	// input teacher information from keyboard then return teacher object
	public static Teacher inputTeacher() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input first name of Teacher");
		String firstName = scanner.nextLine();
		System.out.println("Input last name of Teacher");
		String lastName = scanner.nextLine();
		System.out.println("Input date of birth with format dd-MM-yyyy");
		String inputDate = scanner.nextLine();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date dateOfBirth = null;
		try {
			dateOfBirth = format.parse(inputDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Input place that Teacher live");
		String place = scanner.nextLine();
		
		Teacher teacher = new Teacher();
		teacher.setFirstName(firstName);
		teacher.setLastName(lastName);
		teacher.setDateOfBirth(dateOfBirth);
		teacher.setPlaceToLive(place);
		return teacher;
	}
	
	
}
