package com.lucio.springboot.demo.controller;

import com.lucio.springboot.demo.entity.Employee;
import com.lucio.springboot.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/employees")
public class EmployeeController {

    // constructor injection of service
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // get employees
    @GetMapping("")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    // get one employee
    @GetMapping("{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    // post
    @PostMapping("")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    // modify
    @PutMapping("")
    public void modifyEmployee(@RequestBody Employee employee) {
        employeeService.modifyEmployee(employee);
    }

    // delete
    @DeleteMapping("{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

}
