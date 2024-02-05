package com.ajil.cruddemo;

import com.ajil.cruddemo.dao.StudentDAO;
import com.ajil.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner CommandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create the multiple student objects
		System.out.println("creating 3 students.......");
		Student tempStudent1 = new Student("Ajil2", "TU", "ajiltu25467@gmail.com");
		Student tempStudent2 = new Student("Ajil3", "TU", "ajiltu35467@gmail.com");
		Student tempStudent3 = new Student("Ajil4", "TU", "ajiltu45467@gmail.com");

		// save the student object
		System.out.println("saving the students.......");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("creating new student.......");
		Student tempStudent = new Student("Ajil", "TU", "ajiltu5467@gmail.com");

		// save the student object
		System.out.println("saving the student.......");
		studentDAO.save(tempStudent);
		// display the id of the saved student
		System.out.println("Student Id is : "+tempStudent.getId());

	}
}