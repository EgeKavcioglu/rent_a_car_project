package com.example.demo.services.abstracts;

import com.example.demo.entities.Customer;
import com.example.demo.services.dtos.requests.customer.AddCustomerRequest;
import com.example.demo.services.dtos.requests.customer.UpdateCustomerRequest;
import com.example.demo.services.dtos.responses.customer.GetCustomerResponse;
import java.util.List;

public interface CustomerService {

    List<Customer> getAll();
    GetCustomerResponse getById(int id);
    void add(AddCustomerRequest addCustomerRequest);
    void update(UpdateCustomerRequest updateCustomerRequest);

    void delete(int id);
    List<Customer> isNull ();
    List<Customer> ignoreName(String name);
    List<Customer> firstNameAndLastNameLike (String firstName, String lastName);
}
