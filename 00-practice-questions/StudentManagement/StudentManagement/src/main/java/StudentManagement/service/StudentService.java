package StudentManagement.service;

import StudentManagement.entity.Student;

import java.util.List;

public interface StudentService {
    Student findById(int id);
    List<Student> findAll();
    Student add(Student student);
    void deleteById(int id);
}
