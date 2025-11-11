package com.cruddemo.demo.dao;

import com.cruddemo.demo.entity.Course;
import com.cruddemo.demo.entity.Instructor;
import com.cruddemo.demo.entity.InstructorDetail;
import com.cruddemo.demo.entity.Student;

import java.util.List;

public interface AppDao {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    void update(Instructor instructor);
    void updateCourse(Course course);
    Course findCourseById(int id);
    void deleteCourseById(int id);
    void save(Course course);
    Course findCourseAndReviewsByCourseId(int id);
    Course findCourseAndStudentsByCourseId(int id);
    Student findStudentAndCoursesByStudentId(int id);
    void update(Student student);
    void deleteStudentById(int id);


}
