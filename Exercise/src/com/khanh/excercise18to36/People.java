package com.khanh.excercise18to36;

import java.util.Date;

// this class can be abstract or not :)
public abstract class People {
	private int id;
	private String firstName;
	private String lastName;
	private java.util.Date dateOfBirth;
	private String placeToLive;
	private int sex;
	private String hobby;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPlaceToLive() {
		return placeToLive;
	}

	public void setPlaceToLive(String placeToLive) {
		this.placeToLive = placeToLive;
	}

	public abstract String toString();

}
