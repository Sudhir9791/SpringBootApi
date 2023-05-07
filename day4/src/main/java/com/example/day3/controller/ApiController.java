package com.example.day3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.day3.model.ApiModel;
import com.example.day3.repository.ApiRepo;

@RestController
@RequestMapping("/api")
public class ApiController {

	    @Autowired
	    private ApiRepo studentRepository;

	    @GetMapping("/student")
	    public List<ApiModel> getAllStudents() {
	        return studentRepository.findAll();
	    }

	    @GetMapping("student/{studentId}")
	    public ResponseEntity<ApiModel> getStudentById(@PathVariable int studentId) {
	        Optional<ApiModel> optionalStudent = studentRepository.findById(studentId);
	        if (optionalStudent.isPresent()) {
	            return ResponseEntity.ok(optionalStudent.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PostMapping("/students")
	    public ResponseEntity<ApiModel> createStudent(@RequestBody ApiModel student) {
	        ApiModel savedStudent = studentRepository.save(student);
	        return ResponseEntity.ok(savedStudent);
	    }
	    @PutMapping("/students")
	    public ResponseEntity<ApiModel> updateStudent(@RequestBody ApiModel student) {
	      
	        ApiModel updatedStudent = studentRepository.save(student);
	        return ResponseEntity.ok(updatedStudent);
	    }

	    @DeleteMapping("/student/{studentId}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable int studentId) {
	        Optional<ApiModel> optionalStudent = studentRepository.findById(studentId);
	        if (optionalStudent.isPresent()) {
	            studentRepository.deleteById(studentId);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	}


