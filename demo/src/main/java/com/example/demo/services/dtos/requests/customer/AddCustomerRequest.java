package com.example.demo.services.dtos.requests.customer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddCustomerRequest {

    private int id;
    private String name;
    private String surname;
    private int age;
    private String number;
    private String city;
    private String address;
    private String phone;
    private String email;

}
