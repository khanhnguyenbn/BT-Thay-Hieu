package com.khanh.excercise18to36;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FindStudent {

	// find student by full name , return list student
	static List<Student> findStudentByFullName(List<Student> students, String key) {
		//init list to return
		List<Student> list = new ArrayList<>();

		// loope for add element to list
		for (int i = 0; i < students.size(); i++) {
			// add if be content with condition
			if ((students.get(i).getFirstName() + " " + students.get(i).getLastName()).toLowerCase()
					.contains(key.toLowerCase())) {
				// add to list
				list.add(students.get(i));
			}
		}
		//return list
		return list;

	}

	// test
	public static void main(String[] args) {
		//init list
		List<Student> list = new ArrayList<>();

		// init student and assign value
		Student student1 = new Student();
		student1.setFirstName("Khanh");
		student1.setLastName("Nguyen");
		student1.setDateOfBirth(new Date());
		student1.setPlaceToLive("Ha Noi");

		// init student and assign value
		Student student2 = new Student();
		student2.setFirstName("Nam");
		student2.setLastName("Nguyen");
		student2.setDateOfBirth(new Date());
		student2.setPlaceToLive("Nghe An");

		// init student and assign value
		Student student3 = new Student();
		student3.setFirstName("Nam");
		student3.setLastName("Pham");
		student3.setDateOfBirth(new Date());
		student3.setPlaceToLive("Nghe An");

		// add student to list
		list.add(student1);
		list.add(student2);
		list.add(student3);

		// show notification
		System.out.println("input full name to search: ");
		Scanner scanner = new Scanner(System.in);
		// input key to search
		String key = scanner.nextLine();

		// return list students match with above key
		List<Student> students = findStudentByFullName(list, key);
		// display all students in list students
		if (students.size() > 0) {
			for (int i = 0; i < students.size(); i++) {
				// display with function toString
				System.out.println(students.get(i).toString());
			}
		} else {
			//show notification no match
			System.out.println("no match for this key");
		}
	}
}
