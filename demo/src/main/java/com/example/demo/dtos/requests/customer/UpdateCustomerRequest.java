package com.example.demo.dtos.requests.customer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCustomerRequest {

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
