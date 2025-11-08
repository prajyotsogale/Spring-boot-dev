package StudentManagement.service;

import StudentManagement.dao.StudentRepository;
import StudentManagement.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        Student result = null;
        if(student.isPresent()){
            result = student.get();
        }else{
            throw new RuntimeException("Cannot find student by id: "+id);
        }

        return result;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student add(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
        System.out.println("Deleted student by id: "+id);
    }
}
