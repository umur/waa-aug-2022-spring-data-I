package com.lab3.waaaug2022springdatai.joincolumn_unidir.service;

import com.lab3.waaaug2022springdatai.joincolumn_unidir.dto.AddressDto;
import com.lab3.waaaug2022springdatai.joincolumn_unidir.entity.Address;

import java.util.List;

public interface AddressService {
    Address save(AddressDto addressDto);

    void delete(int id);

    Address getById(int id);

    List<Address> getAll();

    Address updateAddress(Address address);
}
