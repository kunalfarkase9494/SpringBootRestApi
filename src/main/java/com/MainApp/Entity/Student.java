package com.MainApp.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Student {
	@Id
	int roll;
	@Column
	String name;
	@Column
	int age;
	
	public int getRoll_no() {
		return roll;
	}
	public void setRoll_no(int roll_no) {
		this.roll = roll_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student [roll_no=" + roll + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
