package com.example.demo.services.dtos.requests.address;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddAddressRequest {
    @NotBlank (message = "Posta kodu boş olamaz.")

    private int id;
    private String country;
    private String city;
    private String postalcode;

}
