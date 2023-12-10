package com.example.demo.controllers;

import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    private final CustomerRepository customerRepository;

    public CustomersController(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    @GetMapping("/all")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @GetMapping("{id}")
    public Customer getById(@PathVariable int id) {
        return customerRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody @Valid Customer customer) {
        customerRepository.save(customer);
    }

    @PutMapping
    public void update(@RequestBody Customer customer) {
        customerRepository.findById(customer.getId()).orElseThrow();
        customerRepository.save(customer);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        customerRepository.deleteById(id);
    }
    @GetMapping("isNull")
    public List<Customer> isNull (){
        return customerRepository.isNull();
    }
    @GetMapping("ignoreName")
    public List<Customer> ignoreName(String name){
        return customerRepository.ignoreName(name);
    }
    @GetMapping("firstNameAndLastNameLike")
    public List<Customer> firstNameAndLastNameLike(@RequestParam String firstName, String lastName){
        return customerRepository.firstNameAndLastNameLike(firstName, lastName);
    }




}
