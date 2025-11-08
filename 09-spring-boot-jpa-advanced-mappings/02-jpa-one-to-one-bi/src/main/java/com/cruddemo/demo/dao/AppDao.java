package com.cruddemo.demo.dao;

import com.cruddemo.demo.entity.Instructor;
import com.cruddemo.demo.entity.InstructorDetail;

public interface AppDao {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
}
