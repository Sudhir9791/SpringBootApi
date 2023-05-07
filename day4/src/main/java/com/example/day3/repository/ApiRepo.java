package com.example.day3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day3.model.ApiModel;

public interface ApiRepo extends JpaRepository<ApiModel,Integer>{

	
}
