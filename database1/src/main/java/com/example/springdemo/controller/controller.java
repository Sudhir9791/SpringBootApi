package com.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.model.model;
import com.example.springdemo.repository.repository;

@RestController

public class controller {
@Autowired
repository obj;
@GetMapping("/get")
public List<model> getdetails(){
	return obj.findAll();
}

@PostMapping("/post")
public model SaveAll(@RequestBody model reg) {
	
	return obj.save(reg);
	
	
	
}
@PutMapping("/put")
public model SaveAlll(@RequestBody model reg) {
	
	return obj.save(reg);
	
	
	
}

@GetMapping("/get/{id}")

public model getDetailsById(@PathVariable int id) {
	
	return obj.findById(id).orElse(null);
}

@DeleteMapping("/delete/{id}")
public String deleteDetailsById(@PathVariable int id) {
	
	obj.deleteById(id);
	return "Details Deleted";
}
@GetMapping("/sortappmodel/{field}")
public List<model> sortmodel(@PathVariable String field){
	
	return obj.sortappmodel(field);
}
}
