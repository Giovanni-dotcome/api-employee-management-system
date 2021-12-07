package com.personal.eme.service;

import com.personal.eme.model.Employee;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    public ResponseEntity<Employee> getEmployeeById(long id);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee, long id);
    Map<String, Boolean> deleteEmployee(long id);
}
