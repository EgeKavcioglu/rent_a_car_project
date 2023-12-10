package com.example.demo.services.dtos.requests.brand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddBrandRequest {

    @NotBlank(message = "Marka adı boş olamaz.")
    @Size(min = 3, max = 20, message = "Marka adı 3 ile 20 hane arasında olmalıdır.")
    private String name;

}
