package com.example.demo.services.dtos.responses.brand;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class GetBrandListResponse {

    private int id;
    private String name;

}
