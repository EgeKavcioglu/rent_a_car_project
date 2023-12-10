package com.example.demo.repositories;

import com.example.demo.entities.Address;
import com.example.demo.services.dtos.responses.address.GetAddressListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    List<Address> findByPostalCodeOrAddressText(String postalCode, String text);
    Address findByAddressTextIgnoreCase(String text);
    @Query("SELECT new com.example.demo.services.dtos.responses.address.GetAddressListResponse" +
            "(a.postalCode,a.addressText, new com.example.demo.services.dtos.responses.city.GetCityListResponse(c.name)) " +
            "from Address a INNER JOIN a.city c WHERE a.addressText = :addressText")
    List<GetAddressListResponse> findByAddressText (String addressText);

    @Query("SELECT new com.example.demo.services.dtos.responses.address.GetAddressListResponse" +
            "(a.postalCode,a.addressText, new com.example.demo.services.dtos.responses.city.GetCityListResponse(c.name))" +
            " FROM Address a INNER JOIN a.city c WHERE a.postalCode = :postalCode AND a.addressText = :addressText")
    List<GetAddressListResponse>findByPostalCodeAndAddressText( String postalCode,String addressText);

}
