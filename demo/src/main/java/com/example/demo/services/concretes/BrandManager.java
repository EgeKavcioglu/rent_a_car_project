package com.example.demo.services.concretes;

import com.example.demo.entities.Brand;
import com.example.demo.repositories.BrandRepository;
import com.example.demo.services.abstracts.BrandService;
import com.example.demo.services.dtos.requests.brand.AddBrandRequest;
import com.example.demo.services.dtos.requests.brand.UpdateBrandRequest;
import com.example.demo.services.dtos.responses.brand.GetBrandListResponse;
import com.example.demo.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.ArrayList;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

     private final BrandRepository brandRepository;

    @Override
    public List<Brand> getAll() {

        return brandRepository.findAll();


    }

    @Override
    public GetBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();

        GetBrandResponse dto = new GetBrandResponse();
        dto.setName(brand.getName());
        return dto;

    }

    @Override
    public void addBrand(AddBrandRequest addBrandRequest) {

        Brand brand = new Brand();

        brand.setName(addBrandRequest.getName());

        brandRepository.save(brand);
    }

    @Override
    public void updateBrand(@PathVariable int id, UpdateBrandRequest updateBrandRequest) {

        Brand brand = brandRepository.findById(updateBrandRequest.getId())
                .orElseThrow(() -> new RuntimeException("Brand not found with id: " + updateBrandRequest.getId()));

        brand.setId(updateBrandRequest.getId());

        brandRepository.save(brand);
    }

        @Override
        public void deleteBrand ( int id){
            brandRepository.deleteById(id);
        }
    }

