package com.orm.service;


import java.util.List;

import com.orm.dto.Student;

public interface StudentService {
	
	void addStudent(Student student);
	public Student findStudentById(int studentId);
	void updateStudentByStudentId(Student studnet);
	void deleteStudentById(int studentId);
	List<Student> displayAllStudentsDetails();
}
