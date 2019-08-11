package com.khanh.excercise18to36;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public class Teacher extends People {
	
	

	Set setSubjectTeaching;
	Map<Subject, Map<Student, Integer>> studentScoreList;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "Teacher  firstName: " + firstName + ", lastName: " + lastName + ", dateOfBirth: " + dateOfBirth + " ,placeToLive: " + placeToLive;
	}
}
