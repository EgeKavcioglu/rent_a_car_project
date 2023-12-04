package com.example.demo.dtos.responses.address;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAddressResponse {

    private int id;
    private String country;
    private String city;
    private String postalcode;
}
