package com.personal.eme.controller;

import com.personal.eme.model.Employee;
import com.personal.eme.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployees(@RequestBody Employee employee, @PathVariable long id) {
        return employeeService.updateEmployee(employee, id);
    }

    @PostMapping("/employees")
    public Employee addEmployees(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployees(@PathVariable long id) {
        return employeeService.deleteEmployee(id);
    }
}
