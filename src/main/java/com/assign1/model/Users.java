package com.assign1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Users {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String passportNumber;
	private String dob;
	
	//Default constructor
	public Users(){
		super();
	}
	
	//
	public Users(Long id,String name,String passportNumber,String dob){
		super();
		this.id = id;
		this.name = name;
		this.passportNumber = passportNumber;
		this.dob = dob ;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", passportNumber=" + passportNumber + ", dob=" + dob
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getPassportNumber()=" + getPassportNumber()
				+ ", getDob()=" + getDob() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
