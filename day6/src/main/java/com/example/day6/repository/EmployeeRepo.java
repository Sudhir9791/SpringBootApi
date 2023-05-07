package com.example.day6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day6.models.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    List<Employee> findByEmail(String email);
}

