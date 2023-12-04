package com.example.demo.services.dtos.responses.address;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAddressListResponse {

    private int id;
    private String country;
    private String city;
    private String postalcode;
}
