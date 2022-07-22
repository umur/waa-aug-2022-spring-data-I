package edu.miu.waa575.lab3springdata.service;

import edu.miu.waa575.lab3springdata.dto.AddressDto;
import edu.miu.waa575.lab3springdata.entity.Address;

import java.util.List;

public interface AddressService{
    List<AddressDto> findAll();
    AddressDto findById(int addressId);
    AddressDto save(AddressDto addressDto);
    Address update(Address address);
    void remove(int addressId);
}
