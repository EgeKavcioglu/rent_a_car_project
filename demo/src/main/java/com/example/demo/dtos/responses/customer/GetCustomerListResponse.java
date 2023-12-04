package com.example.demo.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCustomerListResponse {

    private int id;
    private String name;
    private String surname;
    private String age;
    private String number;
    private String city;
    private String address;
    private String phone;
    private String email;

}
