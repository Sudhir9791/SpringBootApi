package com.example.springdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class model {
	@Id
	
	private int id;
	private String city;
	private String name;
	private String dept;
	private String email;
	private String gender;
	
	model(){}
	public int getReg() {
		return id;
	}
	public void setReg(int reg) {
		this.id = reg;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email =email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender =gender;
	}

}
