package com.ajil.cruddemo;

import com.ajil.cruddemo.dao.StudentDAO;
import com.ajil.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner CommandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO);

			//createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			 //updateStudent(studentDAO);

			deleteStudent(studentDAO);
		};
	}



	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Scooby"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Scooby");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);


	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("creating student....");
		Student tempStudent = new Student("Ajil5", "T U", "ajil@gmail.com");

		// save the student
		System.out.println("saving student....");
		studentDAO.save(tempStudent);

		// display the id of the saved student
		int theId = tempStudent.getId();
		System.out.println("saved student. Generated Id " + theId);

		// retrieve the student based on the id: Primary Key
		System.out.println("retrieving student with the given Id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found student: " + myStudent);
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
