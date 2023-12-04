package com.example.demo.services.dtos.requests.order;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateOrderRequest {

    private int id;
    private int carid;
    private int startdate;
    private int enddate;
    private String totalprice;
}
