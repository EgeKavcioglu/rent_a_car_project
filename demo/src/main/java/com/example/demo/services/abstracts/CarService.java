package com.example.demo.services.abstracts;

import com.example.demo.services.dtos.requests.car.AddCarRequest;
import com.example.demo.services.dtos.requests.car.UpdateCarRequest;
import com.example.demo.services.dtos.responses.car.GetCarListResponse;
import com.example.demo.services.dtos.responses.car.GetCarResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CarService {

    GetCarResponse getById(int id);

    List<GetCarResponse> getAll();

    void add(AddCarRequest addCarRequest);

    void update(@PathVariable int id, UpdateCarRequest updateCarRequest);

    void delete(int id);


}
