package com.cruddemo.demo.dao;

import com.cruddemo.demo.entity.Course;
import com.cruddemo.demo.entity.Instructor;
import com.cruddemo.demo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Temporal;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDao{

    private EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        List<Course> list = instructor.getCourses();

        for(Course tempCourse: list){
            tempCourse.setInstructor(null);
        }
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> theQuery = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        theQuery.setParameter("data", id);

        List<Course> list = theQuery.getResultList();
        return list;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> theQuery = entityManager.createQuery(
                                                        "select i from Instructor i"
                                                        +" JOIN FETCH i.courses "
                                                        +"JOIN FETCH i.instructorDetail "
                                                        +"where i.id = :data", Instructor.class);
        theQuery.setParameter("data",id);
        Instructor instructor = theQuery.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {
        TypedQuery<Course> theQuery = entityManager.createQuery(
                "select c from Course c "
                +"JOIN FETCH c.reviews "
                +"where c.id = :data", Course.class
        );
        theQuery.setParameter("data", id);
        Course course = theQuery.getSingleResult();
        return course;
    }


}
