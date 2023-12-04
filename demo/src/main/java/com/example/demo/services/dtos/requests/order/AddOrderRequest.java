package com.example.demo.services.dtos.requests.order;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddOrderRequest {

    private int startdate;
    private int enddate;
    private double totalprice;

}