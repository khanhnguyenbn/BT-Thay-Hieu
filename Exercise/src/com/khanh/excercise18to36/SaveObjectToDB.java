package com.khanh.excercise18to36;

import java.util.Scanner;

public class SaveObjectToDB {
	
	public static void main(String[] args) {
		
		//insert student to DB with value input from keyboard with base information before
		StudentDAO studentDAO = new StudentDAO();
		// init student from keyboard
		Student student = InputObjectFromKeyboard.inputStudent();
		// save in DB
		studentDAO.insert(student);
		
		// insert subject to DB with value input from keyboard
		SubjectDAO subjectDAO = new SubjectDAO();
		// init subject from keyboard
		Subject subject = InputObjectFromKeyboard.inputSubject();
		// save in DB
		subjectDAO.insert(subject);
		
		//insert teacher to DB with value input from keyboard with base information before
		TeacherDAO teacherDAO = new TeacherDAO();
		// init teacher from keyboard
		Teacher teacher = InputObjectFromKeyboard.inputTeacher();
		// save in DB
		teacherDAO.insert(teacher);
		
		//then Teacher register subject to teach and save to DB
		Scanner scanner = new Scanner(System.in);
		// show notification to iput teacher id
		System.out.println("Input your teacher id to register teaching");
		// input teacher id
		int teacherId = scanner.nextInt();
		// show notification to input subject id
		System.out.println("Input subject id you teach");
		// input subject id
		int subjectId = scanner.nextInt();
		// that teacher register that subject
		TeachingAndLearningRegistration.registerSubjectTeaching(teacherId, subjectId);
		
		// then Student register subject and teacher to learn and save to DB
		// show notification to input student id
		System.out.println("input your student id to register subject");
		// input student id
		int studentId = scanner.nextInt();
		// show notification to input teaching id
		System.out.println("input id teaching to register teacher and subject");
		// input teaching id (that have teacher id and subject id)
		int teachingId = scanner.nextInt();
		// student register subject to learn
		TeachingAndLearningRegistration.registerSubjectLearning(studentId, teachingId);
		
	}
}
