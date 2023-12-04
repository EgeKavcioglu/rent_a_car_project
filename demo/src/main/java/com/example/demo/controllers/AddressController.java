package com.example.demo.controllers;

import com.example.demo.entities.Address;
import com.example.demo.services.abstracts.AddressService;
import com.example.demo.services.dtos.requests.address.AddAddressRequest;
import com.example.demo.services.dtos.requests.address.UpdateAddressRequest;
import com.example.demo.services.dtos.responses.address.GetAddressResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {

        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @GetMapping("{id}")
    public GetAddressResponse getById(@PathVariable int id) {
        return addressService.getById(id);
    }

    @PostMapping
    public void addService(@RequestBody AddAddressRequest addAddressRequest) {
        this.addressService.addService(addAddressRequest);
    }

    @PutMapping("{id}")
    public void updateService(@PathVariable int id, @RequestBody UpdateAddressRequest updateAddressRequest) {
        this.addressService.updateService(id,updateAddressRequest);
    }

    @DeleteMapping("{id}")
    public void deleteService(@PathVariable int id) {
        this.addressService.deleteService(id);
    }

}

