package com.example.springdemo.repository;



import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springdemo.model.model;

@Repository
public interface repository extends JpaRepository <model,Integer>{

	public default List<model>sortappmodel(String field)
	{
		return findAll(Sort.by(Direction.ASC,field));
	}

	

	

}
