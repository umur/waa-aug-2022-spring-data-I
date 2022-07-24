package com.miu.spring.data.service;

import com.miu.spring.data.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface AddressService {
    List<Address> getAllAddresses();
    Address saveAddress(Address address);
    void deleteAddress(int id);
    Optional<Address> getAddressById(int id);
}
