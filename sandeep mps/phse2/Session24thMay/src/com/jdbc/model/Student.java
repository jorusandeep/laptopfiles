package com.jdbc.model;
/*
 * Create Table Student(rollno int auto_increment primary key, 
stdname varchar(20), 
course varchar(20), 
fees float);
 */

public class Student {

	private int rollno;
	private String stdname;
	private String course;
	private float fees;
	
	public int getRollno() {
		return rollno;
	}
	
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStdname() {
		return stdname;
	}
	public void setStdname(String stdname) {
		this.stdname = stdname;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public float getFees() {
		return fees;
	}
	public void setFees(float fees) {
		this.fees = fees;
	}
}
