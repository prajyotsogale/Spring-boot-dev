package com.crud.demoexample.cruddemo;

import com.crud.demoexample.cruddemo.dao.StudentDAO;
import com.crud.demoexample.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner ->{

			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);

		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple student objects
		Student tempStudent1 = new Student("Ganesh","Rao","ganesh@gmail.com");
		Student tempStudent2 = new Student("bonita","rodrigues","bonite@gmail.com");
		Student tempStudent3 = new Student("priya","patil","priya@gmail.com");

		//save the objects
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new Student object..");
		Student tempStudent = new Student("john","doe","abc@gmail.com");
		//save the student object
		System.out.println("Saving the student object...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}

}
