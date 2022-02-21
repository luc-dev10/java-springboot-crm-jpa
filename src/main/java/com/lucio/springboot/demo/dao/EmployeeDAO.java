package com.lucio.springboot.demo.dao;

import com.lucio.springboot.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getEmployees();

    public Employee getEmployee(int id);

    public void addEmployee(Employee employee);

    public void deleteEmployee(int id);

    public Employee modifyEmployee(Employee employee);

}
