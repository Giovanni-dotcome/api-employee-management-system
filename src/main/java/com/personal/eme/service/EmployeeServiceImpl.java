package com.personal.eme.service;

import com.personal.eme.model.Employee;
import com.personal.eme.repository.EmployeeRepository;
import com.personal.eme.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public ResponseEntity<Employee> getEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Employee not found")
        );
        return ResponseEntity.ok(employee);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        Employee result;
        try {
            result = employeeRepository.save(employee);
        } catch (IllegalArgumentException ex) {
            result = new Employee("Error on adding the employee data");
        }
        return result;
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee result;
        try {
            Employee oldEmployee = employeeRepository.findById(id).get();
            oldEmployee.setFirstName(employee.getFirstName());
            oldEmployee.setLastName(employee.getLastName());
            oldEmployee.setEmailId(employee.getEmailId());
            result = employeeRepository.save(oldEmployee);
        } catch (IllegalArgumentException ex) {
            result = new Employee("Error on updating the employee data");
        }

        return result;
    }

    @Override
    public Map<String, Boolean> deleteEmployee(long id) {
        Map<String, Boolean> result = new HashMap<>();
        try {
            employeeRepository.deleteById(id);
            result.put("deletion", true);
        } catch (IllegalArgumentException ex) {
            result.put("deletion", true);
        }
        return result;
    }
}
