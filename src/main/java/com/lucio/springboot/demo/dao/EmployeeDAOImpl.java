package com.lucio.springboot.demo.dao;

import com.lucio.springboot.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
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
        // Session
        Session session = entityManager.unwrap(Session.class);
        // query
        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        // execute query for list
        return query.getResultList();
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        // session
        Session session = entityManager.unwrap(Session.class);
        return session.get(Employee.class, id);
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.save(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);
        if (employee != null)
            session.delete(employee);
    }

    @Override
    @Transactional
    public Employee modifyEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.update(employee);
        return employee;
    }
}
