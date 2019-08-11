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
		return  "Teacher  firstName: " + getFirstName() + ", lastName: " + getLastName() + ", dateOfBirth: " + getDateOfBirth() + " ,placeToLive: " + getPlaceToLive();
	}

	public Set getSetSubjectTeaching() {
		return setSubjectTeaching;
	}

	public void setSetSubjectTeaching(Set setSubjectTeaching) {
		this.setSubjectTeaching = setSubjectTeaching;
	}

	public Map<Subject, Map<Student, Integer>> getStudentScoreList() {
		return studentScoreList;
	}

	public void setStudentScoreList(Map<Subject, Map<Student, Integer>> studentScoreList) {
		this.studentScoreList = studentScoreList;
	}
	
	
}
