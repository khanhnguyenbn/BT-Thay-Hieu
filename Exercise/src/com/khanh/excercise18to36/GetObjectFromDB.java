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
		// using itorator for get element
		Iterator iterator = set.iterator();
		System.out.println("List subject and score of student: ");
		//get each element
		while (iterator.hasNext()) {
			// entry is each element
			Map.Entry<Subject, Integer> entry = (Map.Entry<Subject, Integer>) iterator.next();
			// show subjet name and score
			System.out.println(entry.getKey().getSubjectName() + " " + entry.getValue());
		}
	}

}
