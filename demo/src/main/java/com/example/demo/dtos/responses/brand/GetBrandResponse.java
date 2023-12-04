package com.example.demo.dtos.responses.brand;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetBrandResponse {

    private int id;
    private String name;
}
