package cs545waa.lab3.service;

import cs545waa.lab3.dto.AddressDto;

import java.util.List;

public interface AddressService {
    List<AddressDto> findAll();
    AddressDto create(AddressDto addressDto);
    void delete(int addressId);
}
