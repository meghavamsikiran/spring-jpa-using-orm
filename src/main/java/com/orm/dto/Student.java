package com.orm.dto;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	private int studentId;
	private String studentName;
	private double marks;
	private java.sql.Date dateOfJoin;
	public Student() {
		super();
	}
	public Student(int studentId, String studentName, double marks, Date dateOfJoin) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.marks = marks;
		this.dateOfJoin = dateOfJoin;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public java.sql.Date getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(java.sql.Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfJoin == null) ? 0 : dateOfJoin.hashCode());
		long temp;
		temp = Double.doubleToLongBits(marks);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + studentId;
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (dateOfJoin == null) {
			if (other.dateOfJoin != null)
				return false;
		} else if (!dateOfJoin.equals(other.dateOfJoin))
			return false;
		if (Double.doubleToLongBits(marks) != Double.doubleToLongBits(other.marks))
			return false;
		if (studentId != other.studentId)
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", marks=" + marks + ", dateOfJoin="
				+ dateOfJoin + "]";
	}
}
