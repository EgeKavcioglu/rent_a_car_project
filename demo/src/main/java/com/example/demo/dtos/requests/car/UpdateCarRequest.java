package com.example.demo.dtos.requests.car;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCarRequest {

    private int id;
    private int model;
    private String brand;
    private String shift;
    private int price;
    private String color;


}
