package com.khanh.excercise18to36;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// write object to file with base information when they not yet register subject to learn and subject to teach
public class WriteObjectToFile {

	public static void main(String args[]) {

		Student student = InputObjectFromKeyboard.inputStudent();
		Subject subject = InputObjectFromKeyboard.inputSubject();
		Teacher teacher = InputObjectFromKeyboard.inputTeacher();

		// each attribute is separated by ","
		try {
			FileWriter fw = new FileWriter("D:\\test.txt");
			fw.write("firstName:" + student.getFirstName() + ",");
			fw.write("lastName:" + student.getLastName() + ",");
			fw.write("dateOfBirth:" + student.getDateOfBirth() + ",");
			fw.write("placeToLive:" + student.getPlaceToLive() + ",");
			fw.write(";");
			fw.write("subjectName:" + subject.getSubjectName());
			fw.write("startDate:" + subject.getStartDate());
			fw.write("endDate" + subject.getEndDate());
			fw.write(";");
			fw.write("firstName:" + teacher.getFirstName() + ",");
			fw.write("lastName:" + teacher.getLastName() + ",");
			fw.write("dateOfBirth:" + teacher.getDateOfBirth() + ",");
			fw.write("placeToLive:" + teacher.getPlaceToLive() + ",");
			fw.write(";");
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Success...");
	}

}
