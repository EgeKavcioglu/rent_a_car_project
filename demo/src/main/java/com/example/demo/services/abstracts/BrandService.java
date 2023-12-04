package com.example.demo.services.abstracts;

import com.example.demo.entities.Brand;
import com.example.demo.services.dtos.requests.brand.AddBrandRequest;
import com.example.demo.services.dtos.requests.brand.UpdateBrandRequest;
import com.example.demo.services.dtos.responses.brand.GetBrandListResponse;
import com.example.demo.services.dtos.responses.brand.GetBrandResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BrandService {

    GetBrandResponse getById(int id);

    List<Brand> getAll();

    void addBrand(AddBrandRequest addBrandRequest);
    void updateBrand(@PathVariable int id, UpdateBrandRequest updateBrandRequest);
    void deleteBrand(int id);

}




