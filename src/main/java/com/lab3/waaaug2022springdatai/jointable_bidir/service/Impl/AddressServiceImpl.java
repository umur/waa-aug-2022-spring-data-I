package com.lab3.waaaug2022springdatai.jointable_bidir.service.Impl;

import com.lab3.waaaug2022springdatai.jointable_bidir.dto.AddressDto;
import com.lab3.waaaug2022springdatai.jointable_bidir.entity.Address;
import com.lab3.waaaug2022springdatai.jointable_bidir.repository.AddressRepository;
import com.lab3.waaaug2022springdatai.jointable_bidir.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final ModelMapper modelMapper;

    @Override
    public Address save(AddressDto addressDto) {
        Address address = modelMapper.map(addressDto, Address.class);
        return addressRepository.save(address);
    }

    @Override
    public void delete(int id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Address getById(int id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }
}
