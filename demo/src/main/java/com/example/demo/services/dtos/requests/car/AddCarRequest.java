package com.example.demo.services.dtos.requests.car;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddCarRequest {
    @NotNull(message = "Model yılı boş olamaz.")

    private int id;
    private int model;
    private String brand;
    private String shift;
    private int price;
    private String color;

}
