package com.example.demo.services.concretes;

import com.example.demo.entities.Address;
import com.example.demo.repositories.AddressRepository;
import com.example.demo.services.abstracts.AddressService;
import com.example.demo.services.dtos.requests.address.AddAddressRequest;
import com.example.demo.services.dtos.requests.address.UpdateAddressRequest;
import com.example.demo.services.dtos.responses.address.GetAddressListResponse;
import com.example.demo.services.dtos.responses.address.GetAddressResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public List<Address> getAll() {
         return addressRepository.findAll();



    }

    @Override
    public GetAddressResponse getById(int id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + id));

        GetAddressResponse dto = new GetAddressResponse();
        dto.setCountry(address.getCountry());
        dto.setCity(address.getCity());
        dto.setPostalcode(address.getPostalcode());


        return dto;
    }

    @Override
    public void addService(AddAddressRequest addAddressRequest) {

        Address address = new Address();

        address.setCountry(addAddressRequest.getCountry());
        address.setCity(addAddressRequest.getCity());
        address.setPostalcode(addAddressRequest.getPostalcode());

        addressRepository.save(address);
    }

    @Override
    public void updateService(@PathVariable int id, UpdateAddressRequest updateAddressRequest) {
        Address updateAddress = addressRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Belirttiğiniz ID ile bir adres kaydı bulunamadı !"));
        updateAddress.setCountry(updateAddressRequest.getCountry());
        updateAddress.setCity(updateAddressRequest.getCity());
        updateAddress.setPostalcode(updateAddressRequest.getPostalcode());

        this.addressRepository.save(updateAddress);
    }

        @Override
        public void deleteService(int id) {
            addressRepository.deleteById(id);

        }

    @Override
    public GetAddressResponse text(String text) {
        Address address=addressRepository.findByAddressTextIgnoreCase(text);
        GetAddressResponse getAddressResponse=new GetAddressResponse();
        getAddressResponse.setId(address.getAddressText());
        return getAddressResponse ;

    }


    @Override
    public List<GetAddressListResponse> findByAddressText( String addressText) {
        return addressRepository.findByAddressText(addressText);
    }
}