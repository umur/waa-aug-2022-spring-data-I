package miu.edu.service;

import miu.edu.dto.AddressDto;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<AddressDto> findAll();

    AddressDto save(AddressDto addressDto);

    AddressDto getOne(int addressId);

    void remove(int addressId);
}
