package com.miu.spring.data.service.impl;

import com.miu.spring.data.entity.Address;
import com.miu.spring.data.repository.AddressRepository;
import com.miu.spring.data.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }
    @Override
    public Address saveAddress(Address address)
    {
        return addressRepository.save(address);
    }
    @Override
    public Optional<Address> getAddressById(int id){
        return addressRepository.findById(id);
    }
    @Override
    public void deleteAddress(int id){
        addressRepository.deleteById(id);
        System.out.println("Address deleted ");
    }

}
