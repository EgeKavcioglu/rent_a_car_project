package com.example.demo.services.dtos.responses.car;

import com.example.demo.services.dtos.responses.brand.GetBrandListResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCarListResponse {

    private int id;
    private int model;
    private GetBrandListResponse brand;
    private String shift;
    private int price;
    private String color;

}
