package com.orm.io;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.orm.config.StudentConfig;
import com.orm.dto.Student;
import com.orm.service.StudentService;
import com.orm.service.StudentServiceImpl;
import com.orm.util.DateConverter;

public class StudentManagement {
	static AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(StudentConfig.class);
	static StudentService studentService = ctx.getBean(StudentServiceImpl.class);
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws ParseException {
//		Scanner sc = new Scanner(System.in);
		boolean running = true;

	    while (running) {
			System.out.println("1. Add Student Record");
			System.out.println("2. Find Student By empId");
			System.out.println("3. Update Student By empId");
			System.out.println("4. Delete Student By empId");
			System.out.println("5. Display All Student's Details");
			System.out.println("6. Exit");
			System.out.println("Select an Option: ");
			int ch = sc.nextInt();
			switch(ch) {
			case 1: addStudentDetails(); break;
			case 2: findStudentById(); break;
			case 3: updateStudentDetailsByStudentId(); break;
			case 4: deleteStudentDataByStudentId(); break;
			case 5: displayAllStudentsDetails(); break;
			case 6: running = false; System.out.println(">>> Services Stopped!"); break;
			default: System.out.println("Invalid Input!"); break;
			}
	    }
	    sc.close();
	}
	
	private static void addStudentDetails() throws ParseException {
//		studentService = ctx.getBean(StudentServiceImpl.class);
//		Scanner sc = new Scanner(System.in);
		System.out.println("Enter studentId: ");
		int studentId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter studentName: ");
		String studentName = sc.nextLine();
		System.out.println("Enter student marks: ");
		double marks = sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter Date of Join(yyyy-MM-dd): ");
        String dateOfJoin = sc.nextLine();
        
        Student student = new Student();
        student.setStudentId(studentId);
        student.setStudentName(studentName);
        student.setMarks(marks);
        student.setDateOfJoin(DateConverter.convertStringToSQLDate(dateOfJoin));
        
        studentService.addStudent(student);
		System.out.println("===> Added student "+student.getStudentId()+" details Successfully!\n");
	}
	
	public static void findStudentById() {
//		studentService = ctx.getBean(StudentServiceImpl.class);
//		Scanner sc = new Scanner(System.in);
		System.out.println("Enter studnetId to find: ");
		int studentId = sc.nextInt();
		Student student = studentService.findStudentById(studentId);
		if(student == null) {
			System.out.println("===> Student with studentId="+studentId+" not found.\n");
			return;
		}
		else
		{
			System.out.println("Found this record "+student+"\n");
		}
	}
	
	private static void updateStudentDetailsByStudentId() throws ParseException {
//		studentService = ctx.getBean(StudentServiceImpl.class);
//		Scanner sc = new Scanner(System.in);
		
		displayAllStudentsDetails();
		
		System.out.println("Enter studentId to update his details: ");
		int studentId = sc.nextInt();
		sc.nextLine();
		
        Student student = studentService.findStudentById(studentId);
	    if(student == null) {
	    	System.out.println("===> No student with studentId="+studentId+" found.\n");
	    	return;
        }
		System.out.println("Enter new studentName: ");
		String studentName = sc.nextLine();
		System.out.println("Enter new student marks: ");
		double marks = sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter new Date of Join(yyyy-MM-dd): ");
        String dateOfJoin = sc.nextLine();
        
        student.setStudentId(studentId);
        student.setStudentName(studentName);
        student.setMarks(marks);
        student.setDateOfJoin(DateConverter.convertStringToSQLDate(dateOfJoin));
        studentService.updateStudentByStudentId(student);
		System.out.println("===> Successfully updated student "+studentId+" data.\n");
	}
	
	public static void deleteStudentDataByStudentId() {
//		studentService = ctx.getBean(StudentServiceImpl.class);
//		Scanner sc = new Scanner(System.in);
		System.out.println("Enter studentId to delete data: ");
		int studentId = sc.nextInt();
		Student student = studentService.findStudentById(studentId);
		if(student == null) {
			System.out.println("===> No student with studentId="+studentId+" found.\n");
			return;
		}
		studentService.deleteStudentById(studentId);
		System.out.println("===> Successfully deleted student "+studentId+" data.\n");
	}
	
	public static void displayAllStudentsDetails() {
//		studentService = ctx.getBean(StudentServiceImpl.class);
		List<Student> list = studentService.displayAllStudentsDetails();
		System.out.println("All Student's Details: ");
		for(Student s: list) {
			System.out.println(s);
		}
		System.out.println();
	}
}
