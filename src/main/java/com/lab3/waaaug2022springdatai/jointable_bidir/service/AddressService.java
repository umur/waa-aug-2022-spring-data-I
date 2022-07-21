package com.lab3.waaaug2022springdatai.jointable_bidir.service;

import com.lab3.waaaug2022springdatai.jointable_bidir.dto.AddressDto;
import com.lab3.waaaug2022springdatai.jointable_bidir.entity.Address;

import java.util.List;

public interface AddressService {
    Address save(AddressDto addressDto);

    void delete(int id);

    Address getById(int id);

    List<Address> getAll();

    Address updateAddress(Address address);
}
