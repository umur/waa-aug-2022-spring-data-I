package com.example.waa_lab3.Service;

import com.example.waa_lab3.DTO.AddressDto;

import java.util.List;

public interface IAddressService {

    List<AddressDto> findAll();
    AddressDto addAddress(AddressDto addressDto);
    AddressDto getAddress(int id);
    AddressDto updateAddress(AddressDto addressDto, int id);
    void deleteAddress(int id);
}
