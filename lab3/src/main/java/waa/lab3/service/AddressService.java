package waa.lab3.service;

import waa.lab3.dto.AddressDto;

import java.util.List;

public interface AddressService {

    List<AddressDto> findAll();

    AddressDto findById(int id);

    void deleteById(int id);

    void saveAddress(AddressDto add);
}
