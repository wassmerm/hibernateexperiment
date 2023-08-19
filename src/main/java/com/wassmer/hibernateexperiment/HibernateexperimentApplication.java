package com.wassmer.hibernateexperiment;

import com.wassmer.hibernateexperiment.dao.StudentDAO;
import com.wassmer.hibernateexperiment.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateexperimentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateexperimentApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Frank", "Miller", "frank.miller@outlook.com");

		System.out.println("Saving student object to DB...");
		studentDAO.save(tempStudent);

		System.out.println("Student object saved. Generated ID: " + tempStudent.getId());
	}

}
