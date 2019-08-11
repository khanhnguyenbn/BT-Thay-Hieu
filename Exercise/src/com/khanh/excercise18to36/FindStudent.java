package com.khanh.excercise18to36;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FindStudent {

	// find student by full name , return list student
	static List<Student> findStudentByFullName(List<Student> students, String key) {
		List<Student> list = new ArrayList<>();

		for (int i = 0; i < students.size(); i++) {
			if ((students.get(i).getFirstName() + " " + students.get(i).getLastName()).toLowerCase()
					.contains(key.toLowerCase())) {
				list.add(students.get(i));
			}
		}
		return list;

	}

	// test
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();

		Student student1 = new Student();
		student1.setFirstName("Khanh");
		student1.setLastName("Nguyen");
		student1.setDateOfBirth(new Date());
		student1.setPlaceToLive("Ha Noi");

		Student student2 = new Student();
		student2.setFirstName("Nam");
		student2.setLastName("Nguyen");
		student2.setDateOfBirth(new Date());
		student2.setPlaceToLive("Nghe An");

		Student student3 = new Student();
		student3.setFirstName("Nam");
		student3.setLastName("Pham");
		student3.setDateOfBirth(new Date());
		student3.setPlaceToLive("Nghe An");

		list.add(student1);
		list.add(student2);
		list.add(student3);

		System.out.println("input full name to search: ");
		Scanner scanner = new Scanner(System.in);
		String key = scanner.nextLine();

		List<Student> students = findStudentByFullName(list, key);
		if (students.size() > 0) {
			for (int i = 0; i < students.size(); i++) {
				System.out.println(students.get(i).toString());
			}
		} else {
			System.out.println("no match for this key");
		}
	}
}
