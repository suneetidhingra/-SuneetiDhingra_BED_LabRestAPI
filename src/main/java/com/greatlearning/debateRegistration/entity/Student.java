package com.greatlearning.debateRegistration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "First_Name")
	private String firstName;
	
	@Column(name = "Last_Name")
	private String lastName;
	
	@Column(name = "Course")
	private String  course;
	
	@Column(name = "Country")
	private String country;
	
	public Student() {}

	public Student( String firstName, String lastName, String course, String country) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.country = country;
	}

	public int getid() {
		return id;
	}

	public void setStudent_id(int id) {
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}