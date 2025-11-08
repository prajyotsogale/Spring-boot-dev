package injection.dao;

import injection.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
    List<Student> fetchAll();
    void updateStudent(Student student);
    void deleteStudent(Integer id);
}
