package com.demo.cruddemo;

import com.demo.cruddemo.dao.StudentDAO;
import com.demo.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner ->{
            createMultipleStudents(studentDAO);

            //readStudent(studentDAO);

            //queryForStudents(studentDAO);
            //getStudentByLastName(studentDAO);

            //updateStudent(studentDAO);
            //deleteStudent(studentDAO);
            //deleteAll(studentDAO);
        };
    }

    private void deleteAll(StudentDAO studentDAO) {
        System.out.println("Deleting all the students");
        int num = studentDAO.deleteAll();
        System.out.printf("Deleted %d rows",num);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int id = 2;
        System.out.println("Deleting student by id: "+id);
        studentDAO.delete(id);
        System.out.println("Deleted");
    }

    private void getStudentByLastName(StudentDAO studentDAO) {
        List<Student> theStudent = studentDAO.findByLastName("doe");
        System.out.println(theStudent);

    }

    private void updateStudent(StudentDAO studentDAO) {
        //retrieve student based on id
        int studentId = 4;
        System.out.println("Getting student with id: "+studentId);
        Student student = studentDAO.findById(studentId);
        System.out.println("Updating student.....");
        //change first name to scooby
        student.setLastName("patil");
        studentDAO.update(student);
        //display updated student
        System.out.println("Displaying student");
        System.out.println(student);
    }

    private void queryForStudents(StudentDAO studentDAO) {
        //get list of students
        System.out.println("Getting the list of students");
        //List<Student> list = studentDAO.findAll("shivam%");
        List<Student> list = studentDAO.findAll();
        //display the list of students
        System.out.println("Displaying the list of students");
        for (Student tempStudent: list){
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        //create student object
        System.out.println("Creating 3 student object......");
        Student student = new Student("John","Wick","johnwick@gmail.com");
        //save the student
        System.out.println("Saving the student....");
        studentDAO.save(student);
        //display id of the saved object
        int id = student.getId();
        System.out.println("Saved student. Generated id: "+id);
        //retrieve the student based on id: primary key
        System.out.println("Retrieving student with id: "+id);
        Student myStudent = studentDAO.findById(id);
        //display student
        System.out.println("Found the student: "+student);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        //create the student object
        System.out.println("Creating 3 student object......");
        Student tempStudent1 = new Student("Jonny","Dove","jonny@gmail.com");
        Student tempStudent2 = new Student("Shivam","kk","shivam@gmail.com");
        Student tempStudent3 = new Student("Raj","ww","raj@gmail.com");
        //save the student object
        System.out.println("Saving the student....");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
        //display id of the saved student
        System.out.println("Saved student. Generated id: "+tempStudent1.getId());
        System.out.println("Saved student. Generated id: "+tempStudent2.getId());
        System.out.println("Saved student. Generated id: "+tempStudent3.getId());

    }

    private void createStudent(StudentDAO studentDAO) {

        //create the student object
        System.out.println("Creating new student object......");
        Student tempStudent = new Student("John","Doe","johndoe@gmail.com");
        //save the student object
        System.out.println("Saving the student....");
        studentDAO.save(tempStudent);
        //display id of the saved student
        System.out.println("Saved student. Generated id: "+tempStudent.getId());
    }
}
