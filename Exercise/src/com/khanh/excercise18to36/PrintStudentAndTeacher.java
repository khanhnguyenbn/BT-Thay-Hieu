package com.khanh.excercise18to36;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

// display student and teacher with base information
public class PrintStudentAndTeacher {

	// sort by first name
	static void sortByFirstName(List<People> list) {

		Comparator<People> comparatorByFirstName = new Comparator<People>() {

			@Override
			public int compare(People o1, People o2) {

				return o2.getFirstName().compareTo(o1.getFirstName());
			}
		};
		Collections.sort(list, comparatorByFirstName);
	}

	// sort by full name
	static void sortByFullName(List<People> list) {

		Comparator<People> comparatorByFirstName = new Comparator<People>() {
			@Override
			public int compare(People o1, People o2) {

				// with full name = first name + " " + last name
				return (o2.getFirstName() + " " + o2.getLastName())
						.compareTo((o1.getFirstName() + " " + o1.getLastName()));
			}
		};
		Collections.sort(list, comparatorByFirstName);
	}

	// test
	public static void main(String[] args) {
		List<People> list = new ArrayList();

		People student1 = new Student();
		student1.setFirstName("Khanh");
		student1.setLastName("Nguyen");
		student1.setDateOfBirth(new Date());
		student1.setPlaceToLive("Ha Noi");

		People student2 = new Student();
		student2.setFirstName("Nam");
		student2.setLastName("Nguyen");
		student2.setDateOfBirth(new Date());
		student2.setPlaceToLive("Nghe An");

		People student3 = new Student();
		student3.setFirstName("Nam");
		student3.setLastName("Pham");
		student3.setDateOfBirth(new Date());
		student3.setPlaceToLive("Nghe An");

		People teacher1 = new Teacher();
		teacher1.setFirstName("Mai");
		teacher1.setLastName("Nguyen");
		teacher1.setDateOfBirth(new Date());
		teacher1.setPlaceToLive("Thai Binh");

		People teacher2 = new Teacher();
		teacher2.setFirstName("Binh");
		teacher2.setLastName("Nguyen");
		teacher2.setDateOfBirth(new Date());
		teacher2.setPlaceToLive("Thai Binh");

		list.add(student1);
		list.add(student2);
		list.add(student3);
		list.add(teacher1);
		list.add(teacher2);

		System.out.println("sort by first Name");
		sortByFirstName(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}

		System.out.println("sort by full Name");
		sortByFullName(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}

	}
}
