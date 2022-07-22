package bekmax.springdata1.service;

import bekmax.springdata1.dto.AddressDto;
import bekmax.springdata1.dto.UserDto;

import java.util.List;

public interface AddressService {
    List<AddressDto> findAll();

    AddressDto save(AddressDto addressDto);

    AddressDto get(Long addressId);

    void delete(Long addressId);
}
