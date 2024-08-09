package com.Crud.Demo.revised.example.CrudRevision.DAO;

import com.Crud.Demo.revised.example.CrudRevision.entity.Student;

public interface StudentDao {
    void save(Student student);
    Student findById(Integer id);
}
