package com.example.waa_lab3.Service.Imp;


import com.example.waa_lab3.DTO.AddressDto;
import com.example.waa_lab3.Domian.Address;
import com.example.waa_lab3.Repository.AddressRepository;
import com.example.waa_lab3.Service.IAddressService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AddressService implements IAddressService {

    @Autowired
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper = new ModelMapper();



    @Override
    public List<AddressDto> findAll() {
        var address = addressRepository.findAll();
        var result = new ArrayList<AddressDto>();
        for (Address address1 : address){
            AddressDto addressDto = new AddressDto();
            addressDto = modelMapper.map(address1, AddressDto.class);
            result.add(addressDto);

        }
       return result;
    }

    @Override
    public AddressDto addAddress(AddressDto addressDto) {
    Address address = modelMapper.map(addressDto, Address.class);
    Address address1 = addressRepository.save(address);
    AddressDto addressDto1 = modelMapper.map(address1, AddressDto.class);

        return addressDto1;
    }

    @Override
    public AddressDto getAddress(int id) {

        Address address = addressRepository.findById(id).orElse(null);
        if(address != null){
            AddressDto addressDto = modelMapper.map(address, AddressDto.class);
            return addressDto;
        }

        return null;
    }

    @Override
    public AddressDto updateAddress(AddressDto addressDto, int id) {
       Address address = addressRepository.findById(id).orElse(null);
       if(address != null){
          Address address1 = modelMapper.map(addressDto, Address.class);
          Address address2 = addressRepository.save(address1);
          AddressDto addressDto1 = modelMapper.map(address2, AddressDto.class);
           return addressDto1;

        }

        return null;
    }

    @Override
    public void deleteAddress(int id) {

        Address address = addressRepository.findById(id).orElse(null);
        if (address != null){

            addressRepository.delete(address);
        }

    }
}
