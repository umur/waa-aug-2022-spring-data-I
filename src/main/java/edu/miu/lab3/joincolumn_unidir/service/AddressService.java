package edu.miu.lab3.joincolumn_unidir.service;

import edu.miu.lab3.joincolumn_unidir.dto.AddressDto;
import edu.miu.lab3.joincolumn_unidir.entity.Address;

import java.util.List;

public interface AddressService {
    Address save(AddressDto addressDto);

    void delete(int id);

    Address getById(int id);

    List<Address> getAll();

    Address updateAddress(Address address);
}
