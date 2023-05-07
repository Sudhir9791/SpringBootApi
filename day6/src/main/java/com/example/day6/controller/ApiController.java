package com.example.day6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.day6.models.Employee;
import com.example.day6.service.ApiService;

@RestController
@RequestMapping("/api/employee")
public class ApiController {
    
    @Autowired
    private ApiService apiService;
    
    @PostMapping("/")
    public boolean addEmployee(@RequestBody Employee employee) {
        return apiService.addEmployee(employee);
    }
    
    @GetMapping("/{field}")
    public List<Employee> getEmployeesByField(@PathVariable String field) {
        return apiService.getEmployeesByField(field);
    }
    
    @GetMapping("/{offset}/{pageSize}")
    public Page<Employee> getEmployeesByPage(@PathVariable int offset, @PathVariable int pageSize) {
        return apiService.getEmployeesByPage(offset, pageSize);
    }
    
    @GetMapping("/{offset}/{pageSize}/{field}")
    public Page<Employee> getEmployeesByPageAndField(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        return apiService.getEmployeesByPageAndField(offset, pageSize, field);
    }
    
    @DeleteMapping("/{id}")
    public boolean deleteEmployeeById(@PathVariable int id) {
        return apiService.deleteEmployeeById(id);
    }
    
    @PutMapping("/{id}")
    public Employee updateEmployeeById(@PathVariable int id, @RequestBody Employee employee) {
        return apiService.updateEmployeeById(id, employee);
    }
}
