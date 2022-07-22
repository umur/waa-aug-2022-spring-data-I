package com.example.springdatademo.service.impl;

import com.example.springdatademo.dto.AddressDto;
import com.example.springdatademo.entity.Address;
import com.example.springdatademo.repository.AddressRepository;
import com.example.springdatademo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<AddressDto> findAll() {
        return addressRepository.findAll().stream().map(address -> addressToDto(address)).collect(Collectors.toList());
    }

    @Override
    public AddressDto save(AddressDto addressDto) {
        return addressToDto(addressRepository.save(dtoToAddress(addressDto)));
    }

    @Override
    public AddressDto findById(int addressId) {
        return addressToDto(addressRepository.findById(addressId).orElse(null));
    }

    @Override
    public AddressDto update(AddressDto addressDto) {
        return addressToDto(addressRepository.save(dtoToAddress(addressDto)));
    }

    @Override
    public void delete(int id) {
        addressRepository.deleteById(id);
    }

    private AddressDto addressToDto(Address address) {
        return modelMapper.map(address, AddressDto.class);
    }

    private Address dtoToAddress(AddressDto addressDto) {
        return modelMapper.map(addressDto, Address.class);
    }
}
