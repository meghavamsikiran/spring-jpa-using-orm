package com.orm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.orm.dto.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	EntityManagerFactory emf;
	EntityManager em=null;
	EntityTransaction et=null;
	
	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		em = emf.createEntityManager();
		et = em.getTransaction();
		et.begin();
		em.persist(student);
		et.commit();
		em.close();
	}

	@Override
	public Student findStudentById(int studentId) {
		em = emf.createEntityManager();
		Student find = em.find(Student.class, studentId);
		return find;
	}

	@Override
	public void updateStudentByStudentId(Student student) {
		// TODO Auto-generated method stub
		em = emf.createEntityManager();
		et = em.getTransaction();
		et.begin();
		Student search = em.find(Student.class, student.getStudentId());
		search.setStudentName(student.getStudentName());
		search.setMarks(student.getMarks());
		search.setDateOfJoin(student.getDateOfJoin());
		et.commit();
		em.close();
	}

	@Override
	public void deleteStudentById(int studentId) {
		// TODO Auto-generated method stub
		em = emf.createEntityManager();
		et =em.getTransaction();
		et.begin();
		Student todelete = em.find(Student.class, studentId);
		em.remove(todelete);
		et.commit();
		em.close();
	}

	@Override
	public List<Student> displayAllStudentsDetails() {
		// TODO Auto-generated method stub
		em = emf.createEntityManager();
		Query selectAll = em.createQuery("SELECT s from Student AS s");
		List<Student> list = selectAll.getResultList();
		return list;
	}
}
