package com.example.demo.services.abstracts;

import com.example.demo.entities.Address;
import com.example.demo.services.dtos.requests.address.AddAddressRequest;
import com.example.demo.services.dtos.requests.address.UpdateAddressRequest;
import com.example.demo.services.dtos.responses.address.GetAddressListResponse;
import com.example.demo.services.dtos.responses.address.GetAddressResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface AddressService {
    List<Address> getAll();
    GetAddressResponse getById(int id);
    void addService(AddAddressRequest addAddressRequest);
    void updateService(@PathVariable int id,UpdateAddressRequest updateAddressRequest);
    void deleteService(int id);
    GetAddressResponse text (String text);
    List<GetAddressListResponse> findByAddressText(String addressText);

    List<GetAddressListResponse> postalCodeAndAddressText(String postalCode, String addressText);
}
