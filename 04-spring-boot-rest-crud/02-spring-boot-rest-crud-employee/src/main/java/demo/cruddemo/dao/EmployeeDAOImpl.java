package demo.cruddemo.dao;

import demo.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    //define fields for entity manager

    private EntityManager entityManager;

    //setup constructor
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee",Employee.class);

        //execute query and get list
        List<Employee> list = theQuery.getResultList();

        //return the results
        return list;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee employee1 = entityManager.merge(employee);
        return employee1;
    }

    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class,id);
        entityManager.remove(employee);
    }
}
