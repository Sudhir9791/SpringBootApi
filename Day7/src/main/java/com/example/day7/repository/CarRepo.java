package com.example.day7.repository;

import org.springframework.stereotype.Repository;

import com.example.day7.model.Car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {

    List<Car> findByOwners(int owners);

    List<Car> findByAddress(String address);
}

