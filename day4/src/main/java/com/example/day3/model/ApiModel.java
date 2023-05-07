package com.example.day3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ApiModel {
	@Id
	private int id;
	private String studentName;
	private String email;
	private int age;
	public ApiModel(int id, String studentName, String email, int age) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.email = email;
		this.age = age;
	}
	public ApiModel() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


}
