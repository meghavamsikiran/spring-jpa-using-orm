package com.orm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orm.dao.StudentDAO;
import com.orm.dto.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDao;
	
	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao.addStudent(student);
	}

	@Override
	public Student findStudentById(int studentId) {
		// TODO Auto-generated method stub
		return studentDao.findStudentById(studentId);
	}

	@Override
	public void updateStudentByStudentId(Student student) {
		// TODO Auto-generated method stub
		studentDao.updateStudentByStudentId(student);
	}

	@Override
	public void deleteStudentById(int studentId) {
		// TODO Auto-generated method stub
		studentDao.deleteStudentById(studentId);
	}

	@Override
	public List<Student> displayAllStudentsDetails() {
		// TODO Auto-generated method stub
		return studentDao.displayAllStudentsDetails();
	}

}
