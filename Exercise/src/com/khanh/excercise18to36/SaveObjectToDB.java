package com.khanh.excercise18to36;

import java.util.Scanner;

public class SaveObjectToDB {
	
	public static void main(String[] args) {
		
		//insert student to DB with value input from keyboard with base information before
		StudentDAO studentDAO = new StudentDAO();
		Student student = InputObjectFromKeyboard.inputStudent();
		studentDAO.insert(student);
		
		// insert subject to DB with value input from keyboard
		SubjectDAO subjectDAO = new SubjectDAO();
		Subject subject = InputObjectFromKeyboard.inputSubject();
		subjectDAO.insert(subject);
		
		//insert teacher to DB with value input from keyboard with base information before
		TeacherDAO teacherDAO = new TeacherDAO();
		Teacher teacher = InputObjectFromKeyboard.inputTeacher();
		teacherDAO.insert(teacher);
		
		//then Teacher register subject to teach and save to DB
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input your teacher id to register teaching");
		int teacherId = scanner.nextInt();
		System.out.println("Input subject id you teach");
		int subjectId = scanner.nextInt();
		TeachingAndLearningRegistration.registerSubjectTeaching(teacherId, subjectId);
		
		// then Student register subject and teacher to learn and save to DB
		System.out.println("input your student id to register subject");
		int studentId = scanner.nextInt();
		System.out.println("input id teaching to register teacher and subject");
		int teachingId = scanner.nextInt();
		TeachingAndLearningRegistration.registerSubjectLearning(studentId, teachingId);
		
	}
}
