package com.cruddemo.demo.dao;

import com.cruddemo.demo.entity.Instructor;

public interface AppDao {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
}
