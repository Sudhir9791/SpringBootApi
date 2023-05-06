package com.example.day7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day7.model.Car;
import com.example.day7.repository.CarRepo;

@RestController
public class ApiController {

    @Autowired
    private CarRepo carRepo;

    @PostMapping("/")
    public boolean addCar(@RequestBody Car car) {
        carRepo.save(car);
        return true;
    }

    @GetMapping("/owners/{owners}")
    public List<Car> getCarsByOwners(@PathVariable int owners) {
        return carRepo.findByOwners(owners);
    }

    @GetMapping("/address/{address}")
    public List<Car> getCarsByAddress(@PathVariable String address) {
        return carRepo.findByAddress(address);
    }
}

