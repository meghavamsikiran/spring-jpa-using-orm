package com.orm.dao;

import java.util.List;

import com.orm.dto.Student;

public interface StudentDAO {
	
	void addStudent(Student student);
	Student findStudentById(int studentId);
	void updateStudentByStudentId(Student student);
	void deleteStudentById(int studentId);
	List<Student> displayAllStudentsDetails();
}
