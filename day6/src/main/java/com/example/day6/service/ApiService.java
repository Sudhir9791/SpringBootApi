package com.example.day6.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day6.models.Employee;
import com.example.day6.repository.EmployeeRepo;

@Service
public class ApiService {
    
    @Autowired
    private EmployeeRepo employeeRepo;
    
    public boolean addEmployee(Employee employee) {
        try {
            employeeRepo.save(employee);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<Employee> getEmployeesByField(String field) {
        switch (field.toLowerCase()) {
            case "name":
                return employeeRepo.findAll(Sort.by(Sort.Direction.ASC, "name"));
            case "email":
                return employeeRepo.findAll(Sort.by(Sort.Direction.ASC, "email"));
            case "age":
                return employeeRepo.findAll(Sort.by(Sort.Direction.ASC, "age"));
            default:
                return Collections.emptyList();
        }
    }
    
    public Page<Employee> getEmployeesByPage(int offset, int pageSize) {
        Pageable pageable = PageRequest.of(offset, pageSize);
        return employeeRepo.findAll(pageable);
    }
    
    public Page<Employee> getEmployeesByPageAndField(int offset, int pageSize, String field) {
        Pageable pageable = PageRequest.of(offset, pageSize, Sort.by(field));
        return employeeRepo.findAll(pageable);
    }
    
    public boolean deleteEmployeeById(int id) {
        try {
            employeeRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Employee updateEmployeeById(int id, Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setAge(employee.getAge());
            return employeeRepo.save(existingEmployee);
        } else {
            return null;
        }
    }
}
