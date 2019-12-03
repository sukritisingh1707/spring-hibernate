package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Employee ")
public class Emp {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@Column
private String name;
@Column
private String gender;
@Column
private String dob;
@Column
private float salary;
@Column
private String designation;
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public int getId() {
	return id;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}

}
