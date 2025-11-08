package injection;

import injection.dao.StudentDAO;
import injection.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(InjectionApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner ->{
            //saveStudent(studentDAO);
            //saveMultipleStudents(studentDAO);
            //findById(studentDAO);
            //fetchAllStudents(studentDAO);
            //updateStudent(studentDAO);
            deleteStudent(studentDAO);
        };
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int id = 1;
        System.out.println("deleting student");
        studentDAO.deleteStudent(id);
        System.out.println("deleted!!");
    }

    private void updateStudent(StudentDAO studentDAO) {
        int id = 4;
        Student student = studentDAO.findById(id);
        student.setEmail("abcc@gmail.com");
        studentDAO.updateStudent(student);
    }

    private void findById(StudentDAO studentDAO) {
        int id = 3;
        Student student = studentDAO.findById(id);
        System.out.println(student);
    }

    private void saveMultipleStudents(StudentDAO studentDAO) {
        System.out.println("creating students");
        Student student = new Student("Arun","jadhav","arun2123@gmail.com");
        Student student1 = new Student("John","Doe","johndoe@gmail.com");
        Student student2 = new Student("Omkar","Patil","omkar@gmail.com");
        Student student3 = new Student("Shivam","sogale","shivam3141@gmail.com");
        System.out.println("saving student");
        studentDAO.save(student);
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);

        System.out.println("saved");
    }

    private void fetchAllStudents(StudentDAO studentDAO) {
        System.out.println("fetching the list");
        List<Student> list = studentDAO.fetchAll();
        System.out.println(list);
    }

    private void saveStudent(StudentDAO studentDAO) {
        System.out.println("creating student");
        Student student = new Student("prajyot","sogale","psogale212@gmail.com");
        System.out.println("saving student");
        studentDAO.save(student);
        System.out.println("saved");
    }
}
