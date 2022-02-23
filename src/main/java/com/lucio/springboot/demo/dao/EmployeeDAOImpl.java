package com.lucio.springboot.demo.dao;

import com.lucio.springboot.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    // Dependency Injection
    private final EntityManager entityManager;

    // set up constructor injection - Autowired not necessary
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> getEmployees() {

        // query
        Query query = entityManager.createQuery("from Employee");
        // execute query for list
        return (List<Employee>) query.getResultList();
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null)
            entityManager.remove(employee);
    }

    @Override
    @Transactional
    public Employee modifyEmployee(Employee employee) {
        return entityManager.merge(employee);
    }
}
