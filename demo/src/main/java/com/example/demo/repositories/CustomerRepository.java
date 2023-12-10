package com.example.demo.repositories;

import com.example.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> isNull();

    List<Customer> ignoreName(String name);

    List<Customer> firstNameAndLastNameLike(String firstName, String lastName);

    @Query("select new com.example.demo.services.dtos.responses.customer.GetCustomerListResponse" +
            "(c.firstName, c.lastName, c.phone) " +
            "from Customer c where c.firstName LIKE %:firstName% AND c.lastName LIKE %:lastName%")
    List<Customer> findByFirstNameAndLastNameIsContaining (String firstName, String lastName);

    List<Customer> findByEmailIsNull();
}
