package edu.miu.lab3.joincolumn_bidir.service;

import edu.miu.lab3.joincolumn_bidir.dto.AddressDto;
import edu.miu.lab3.joincolumn_bidir.entity.Address;

import java.util.List;

public interface AddressService {
    Address save(AddressDto addressDto);

    void delete(int id);

    Address getById(int id);

    List<Address> getAll();

    Address updateAddress(Address address);
}
