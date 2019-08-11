package com.khanh.excercise18to36;

import java.util.Date;

public class Subject {
	private int id;
	private String subjectName;
	private Date startDate;
	private Date endDate;
	
	
	
	public Subject() {
		
	}
	
	public Subject(String subjectName, Date startDate, Date endDate) {
		this.subjectName = subjectName;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	

	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
