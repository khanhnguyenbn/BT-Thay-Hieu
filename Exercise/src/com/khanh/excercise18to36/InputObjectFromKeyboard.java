package com.khanh.excercise18to36;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputObjectFromKeyboard {

	// input subject information and return a subject object
	public static Subject inputSubject() {
		Scanner scanner = new Scanner(System.in);
		// show  notification to input subject
		System.out.println("Input subject name: ");
		//input subject name
		String subjectName = scanner.nextLine();
		// show notification to input start date with this format 
		System.out.println("Input start date with format dd-MM-yyyy");
		// input start date
		String inputStartDate = scanner.nextLine();
		//define format 
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date startDate = null;
		Date endDate = null;
		try {
			// convert from String into Date
			startDate = format.parse(inputStartDate);
			// show notification to input
			System.out.println("Input end date with format dd-MM-yyyy");
			//input end date
			String inputEndDate = scanner.nextLine();
			// convert from String to Data
			endDate = format.parse(inputEndDate);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			// display error when parse
			e.printStackTrace();
		}

		return new Subject(subjectName, startDate, endDate);

	}

	// input information of student from keyboard and return that student
	public static Student inputStudent() {
		Scanner scanner = new Scanner(System.in);
		//show notification to input first name
		System.out.println("Input first name of student");
		// input first name
		String firstName = scanner.nextLine();
		//show notification to input last name
		System.out.println("Input last name of student");
		String lastName = scanner.nextLine();
		//show notification to input date of birth
		System.out.println("Input date of birth with format dd-MM-yyyy");
		// input date of birth
		String inputDate = scanner.nextLine();
		// define format 
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date dateOfBirth = null;
		try {
			// parse
			dateOfBirth = format.parse(inputDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			// show error when parse
			e.printStackTrace();
		}

		// show notification to input place to live
		System.out.println("Input place that student live");
		// input place to live
		String place = scanner.nextLine();

		// define and assign student
		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setDateOfBirth(dateOfBirth);
		student.setPlaceToLive(place);
		
		// return that student
		return student;

	}

	// input teacher information from keyboard then return teacher object
	public static Teacher inputTeacher() {
		Scanner scanner = new Scanner(System.in);
		//show notification to input first name
		System.out.println("Input first name of Teacher");
		// input first name
		String firstName = scanner.nextLine();
		//show notification to input last name
		System.out.println("Input last name of Teacher");
		// input last name
		String lastName = scanner.nextLine();
		//show notification to input date of birth
		System.out.println("Input date of birth with format dd-MM-yyyy");
		// input date of birth
		String inputDate = scanner.nextLine();
		//define format
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		// init dateOfBirth
		Date dateOfBirth = null;
		try {
			// parse
			dateOfBirth = format.parse(inputDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// show notification to input place
		System.out.println("Input place that Teacher live");
		// input place
		String place = scanner.nextLine();

		// init and set value for teacher
		Teacher teacher = new Teacher();
		teacher.setFirstName(firstName);
		teacher.setLastName(lastName);
		teacher.setDateOfBirth(dateOfBirth);
		teacher.setPlaceToLive(place);
		
		// return that teacher
		return teacher;
	}

}
