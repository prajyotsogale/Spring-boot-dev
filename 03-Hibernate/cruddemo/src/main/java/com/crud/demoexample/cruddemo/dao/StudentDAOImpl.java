package com.crud.demoexample.cruddemo.dao;

import com.crud.demoexample.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //define the field for entitymanager
    public EntityManager entityManager;
    //inject the entity manager
    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }
    //implement the save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
}
