package com.example.demo.services.concretes;

import com.example.demo.entities.Car;
import com.example.demo.repositories.CarRepository;
import com.example.demo.services.abstracts.CarService;
import com.example.demo.services.dtos.requests.car.AddCarRequest;
import com.example.demo.services.dtos.requests.car.UpdateCarRequest;
import com.example.demo.services.dtos.responses.car.GetCarListResponse;
import com.example.demo.services.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private final CarRepository carRepository;

    @Override
    public GetCarResponse getById(int id) {

        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));

        GetCarResponse dto = new GetCarResponse();
        dto.setId(car.getId());
        dto.setModel(car.getModel());
        dto.setShift(car.getShift());
        dto.setPrice(car.getPrice());
        dto.setColor(car.getColor());

        return dto;
    }

    @Override
    public List<GetCarListResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        List<GetCarListResponse> responseList = new ArrayList<>();

        for (Car car : cars) {
            GetCarListResponse response = new GetCarListResponse();

            car.setId(car.getId());
            car.setModel(car.getModel());
            car.setShift(car.getShift());
            car.setPrice(car.getPrice());
            car.setColor(car.getColor());

            responseList.add(response);
        }

        return responseList;
    }

    @Override
    public void add(AddCarRequest addCarRequest) {
        Car car = new Car();

        car.setId(addCarRequest.getId());
        car.setModel(addCarRequest.getModel());
        car.setShift(addCarRequest.getShift());
        car.setPrice(addCarRequest.getPrice());
        car.setColor(addCarRequest.getColor());

        carRepository.save(car);
    }

    @Override
    public void update(@PathVariable int id, UpdateCarRequest updateCarRequest) {
       Car car = carRepository.findById(id).orElseThrow();
        car.setId(updateCarRequest.getId());
        car.setModel(updateCarRequest.getModel());
        car.setShift(updateCarRequest.getShift());
        car.setPrice(updateCarRequest.getPrice());
        car.setColor(updateCarRequest.getColor());
    }

    @Override
    public void delete(int id){
        carRepository.deleteById(id);
    }
}

