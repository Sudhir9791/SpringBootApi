package com.example.day7.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day7.model.Car;
import com.example.day7.repository.CarRepo;


@Service
public class ApiService {

    @Autowired
    private CarRepo carRepo;

    public boolean saveCar(Car car) {
        try {
            carRepo.save(car);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Car> getCarsByOwners(int owners) {
        return carRepo.findByOwners(owners);
    }

    public List<Car> getCarsByAddress(String address) {
        return carRepo.findByAddress(address);
    }
}

