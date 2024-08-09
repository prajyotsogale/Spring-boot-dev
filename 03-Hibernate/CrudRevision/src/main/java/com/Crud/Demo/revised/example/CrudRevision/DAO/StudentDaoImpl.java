package com.Crud.Demo.revised.example.CrudRevision.DAO;

import com.Crud.Demo.revised.example.CrudRevision.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDaoImpl implements StudentDao {

    public EntityManager entityManager;



    @Autowired
    public StudentDaoImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    //create
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
    //read
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

}
