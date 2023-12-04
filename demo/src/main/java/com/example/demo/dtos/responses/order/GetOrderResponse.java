package com.example.demo.dtos.responses.order;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetOrderResponse {

    private int id;
    private int carid;
    private int customerid;
    private int startdate;
    private int enddate;
    private String totalprice;

}
