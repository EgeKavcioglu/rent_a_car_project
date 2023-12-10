package com.example.demo.services.concretes;

import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.services.abstracts.CustomerService;
import com.example.demo.services.dtos.requests.customer.AddCustomerRequest;
import com.example.demo.services.dtos.requests.customer.UpdateCustomerRequest;
import com.example.demo.services.dtos.responses.customer.GetCustomerListResponse;
import com.example.demo.services.dtos.responses.customer.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
         return customerRepository.findAll();
    }

    @Override
    public GetCustomerResponse getById(int id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        GetCustomerResponse dto = new GetCustomerResponse();

        dto.setName(customer.getName());
        dto.setSurname(customer.getSurname());

        return dto;
    }

    @Override
    public void add(AddCustomerRequest addCustomerRequest) {

        Customer customer = new Customer();
        customer.setId(addCustomerRequest.getId());
        customer.setName(addCustomerRequest.getName());
        customer.setSurname(addCustomerRequest.getSurname());
        customer.setAge(addCustomerRequest.getAge());
        customer.setNumber(addCustomerRequest.getNumber());
        customer.setCity(addCustomerRequest.getCity());
        customer.setPhone(addCustomerRequest.getPhone());
        customer.setEmail(addCustomerRequest.getEmail());

        customerRepository.save(customer);

    }

    @Override
    public void update(UpdateCustomerRequest updateCustomerRequest) {

        Customer customer = customerRepository.findById(updateCustomerRequest.getId())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + updateCustomerRequest.getId()));

        customer.setId(updateCustomerRequest.getId());
        customer.setName(updateCustomerRequest.getName());
        customer.setSurname(updateCustomerRequest.getSurname());
        customer.setAge(updateCustomerRequest.getAge());
        customer.setNumber(updateCustomerRequest.getNumber());
        customer.setCity(updateCustomerRequest.getCity());
        customer.setPhone(updateCustomerRequest.getPhone());
        customer.setEmail(updateCustomerRequest.getEmail());

        customerRepository.save(customer);
    }

     @Override
     public void delete(int id) {
         this.customerRepository.deleteById(id);
        }
    @Override
    public List<Customer> isNull() {
        List<Customer> customerList=customerRepository.findByEmailIsNull();
        List<Customer> getCustomerListResponses =new ArrayList<>();
        for (Customer customer: customerList){
            GetCustomerListResponse responses =new GetCustomerListResponse();
            responses.setSurname(customer.getSurname());
            responses.setName(customer.getName());
            responses.setPhone(customer.getPhone());
            responses.setEmail(customer.getEmail());
            getCustomerListResponses.add(customer);
        }
        return getCustomerListResponses;
    }
    @Override
    public List<Customer> firstNameAndLastNameLike(String firstName, String lastName) {
        return customerRepository.findByFirstNameAndLastNameIsContaining(firstName, lastName);
    }

    }

