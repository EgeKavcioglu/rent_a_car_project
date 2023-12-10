package com.example.demo.controllers;

import com.example.demo.services.abstracts.BrandService;
import com.example.demo.services.dtos.requests.brand.AddBrandRequest;
import com.example.demo.services.dtos.requests.brand.UpdateBrandRequest;
import com.example.demo.services.dtos.responses.brand.GetBrandListResponse;
import com.example.demo.services.dtos.responses.brand.GetBrandResponse;
import com.example.demo.entities.Brand;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
    private final BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<Brand> getAll() {
        return brandService.getAll();
    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id) {
        return this.brandService.getById(id);
    }
    @PostMapping
    public void addBrand(@RequestBody @Valid AddBrandRequest request) {
        this.brandService.addBrand(request);
    }
    @PutMapping("{id}")
    public void updateBrand(@PathVariable int id,@RequestBody UpdateBrandRequest updateBrandRequest) {
        this.brandService.updateBrand(id,updateBrandRequest);
    }
    @DeleteMapping("{id}")
    public void deleteBrand(@PathVariable int id) {
        this.brandService.deleteBrand(id);
    }
    @GetMapping("getByName")
    public List<GetBrandListResponse> getByName(@RequestParam String name, @RequestParam int id) {
        return this.brandService.getByName(name,id);
    }
    @GetMapping("search")
    public List<Brand> search(@RequestParam String name) {
        return brandService.search(name);
    }
    @GetMapping("search2")
    public List<Brand> search2(@RequestParam String name){
        return this.brandService.search2(name);
    }

}




