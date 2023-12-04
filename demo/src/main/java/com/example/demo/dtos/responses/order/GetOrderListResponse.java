package com.example.demo.dtos.responses.order;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetOrderListResponse {

    private int id;
    private int carid;
    private int customerid;
    private int startdate;
    private int enddate;
    private double totalprice;

}

