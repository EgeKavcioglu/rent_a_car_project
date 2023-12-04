package com.example.demo.services.dtos.requests.brand;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddBrandRequest {

    private int id;
    private String name;

}
