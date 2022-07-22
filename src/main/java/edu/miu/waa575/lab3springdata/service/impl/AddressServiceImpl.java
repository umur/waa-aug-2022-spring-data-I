package edu.miu.waa575.lab3springdata.service.impl;

import edu.miu.waa575.lab3springdata.dto.AddressDto;
import edu.miu.waa575.lab3springdata.entity.Address;
import edu.miu.waa575.lab3springdata.repository.AddressRepository;
import edu.miu.waa575.lab3springdata.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<AddressDto> findAll() {
        return addressRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public AddressDto findById(int addressId) {
        return addressRepository.findById(addressId).map(this::toDto).orElse(null);
    }

    @Override
    public AddressDto save(AddressDto addressDto) {
        addressRepository.save(dtoToEntity(addressDto));
        return addressDto;
    }

    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void remove(int addressId) {
        addressRepository.deleteById(addressId);
    }

    //MappeR
    private AddressDto toDto(Address address) {
        return modelMapper.map(address, AddressDto.class);
    }

    private Address dtoToEntity(AddressDto addressDto) {
        return modelMapper.map(addressDto, Address.class);
    }
}
