package com.lucio.springboot.demo.service;

import com.lucio.springboot.demo.dao.EmployeeDAO;
import com.lucio.springboot.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // Autowired DAO
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

    @Override
    public Employee modifyEmployee(Employee employee) {
        return employeeDAO.modifyEmployee(employee);
    }
}
