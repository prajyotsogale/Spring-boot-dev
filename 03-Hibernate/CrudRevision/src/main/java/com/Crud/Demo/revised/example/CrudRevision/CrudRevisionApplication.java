package com.Crud.Demo.revised.example.CrudRevision;

import com.Crud.Demo.revised.example.CrudRevision.DAO.StudentDao;
import com.Crud.Demo.revised.example.CrudRevision.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudRevisionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudRevisionApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner ->{
			//createAndSave(studentDao);
			readStudent(studentDao);
		};
	}


	private void createAndSave(StudentDao studentDao){
		Student student = new Student("Toji","Zenin","toji@gmail.com");
		studentDao.save(student);
		System.out.println("Saved the student at id: "+student.getId());
	}
	private void readStudent(StudentDao studentDao){
		Student student = new Student("Megumi","Fushiguro","megumi@gmail.com");
		studentDao.save(student);

		int id = student.getId();
		System.out.println("Student saved at id: "+id);

		System.out.println("retrieving the student with id: "+id);
		Student mystudent = studentDao.findById(id);

		System.out.println(mystudent);

		System.out.println("reading student at id: "+1+" .....");
		mystudent = studentDao.findById(1);
		System.out.println(mystudent);
		System.out.println("reading student at id: "+2+" .....");
		mystudent = studentDao.findById(2);
		System.out.println(mystudent);
		System.out.println("reading student at id: "+3+" .....");
		mystudent = studentDao.findById(3);
		System.out.println(mystudent);
		System.out.println("reading student at id: "+4+" .....");
		mystudent = studentDao.findById(4);
		System.out.println(mystudent);


	}

}
