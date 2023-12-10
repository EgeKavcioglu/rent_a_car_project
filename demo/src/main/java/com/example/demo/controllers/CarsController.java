package com.example.demo.controllers;


import com.example.demo.entities.Car;
import com.example.demo.repositories.CarRepository;
import com.example.demo.services.dtos.responses.car.GetCarListResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import javax.management.openmbean.CompositeData;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarsController {

    private final CarRepository carRepository;

    public CarsController(CarRepository carRepository) {

        this.carRepository = carRepository;
    }

    @GetMapping("/all")
    public List<GetCarListResponse> getAll() {
        return carRepository.findAll();
    }

    @GetMapping("{id}")
    public Car getById(@PathVariable int id) {
        return carRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody @Valid Car car) {
        carRepository.save(car);
    }

    @PutMapping
    public void update(@RequestBody Car car) {
        carRepository.findById(car.getId()).orElseThrow();
        carRepository.save(car);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        carRepository.deleteById(id);
    }

    @GetMapping
    public List<GetCarListResponse> getAll() {
        return carRepository.getAll();
    }
}

