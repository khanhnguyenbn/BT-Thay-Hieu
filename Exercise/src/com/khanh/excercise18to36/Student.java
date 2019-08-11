package com.khanh.excercise18to36;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class Student extends People{

	/**
	 * 
	 */
	// this attribute save list subject and score of this subject
	Map<Subject, Integer> subjectScore;
	
	

	public Map<Subject, Integer> getSubjectScore() {
		return subjectScore;
	}



	public void setSubjectScore(Map<Subject, Integer> score) {
		this.subjectScore = score;
	}



	// to eassy to display
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student firstName: " + firstName + ", lastName: " + lastName + ", dateOfBirth: " + dateOfBirth + " ,placeToLive: " + placeToLive;
	}
	
	
	
	
	
	
	
}
