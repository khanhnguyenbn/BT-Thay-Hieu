package com.khanh.excercise18to36;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// after student, teacher register subject to learn and teach, information saved to DB
// then get object with that information from DB
public class GetObjectFromDB {

	public static void main(String[] args) {
		StudentDAO studentDAO = new StudentDAO();
		// get student by id
		Student student = studentDAO.getStudentById(1);
		
		// display base information
		System.out.println(student.toString());
		
		// display subject and score of this student
		Set set = student.getSubjectScore().entrySet();
		Iterator iterator = set.iterator();
		System.out.println("List subject and score of student: ");
		while (iterator.hasNext()) {
			Map.Entry<Subject, Integer> entry = (Map.Entry<Subject, Integer>)iterator.next();
			System.out.println(entry.getKey().getSubjectName() + " " + entry.getValue());
		}
	}
	
}
