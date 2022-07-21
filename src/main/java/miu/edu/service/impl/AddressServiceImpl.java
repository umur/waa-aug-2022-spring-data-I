package miu.edu.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.AddressDto;
import miu.edu.entity.Address;
import miu.edu.repository.AddressRepository;
import miu.edu.service.AddressService;
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
        return addressRepository.findAll().stream().map(this::addressToDto).collect(Collectors.toList());
    }

    @Override
    public AddressDto save(AddressDto addressDto) {
        addressRepository.save(dtoToAddress(addressDto));
        return addressDto;
    }

    @Override
    public AddressDto getOne(int addressId) {
        return addressRepository.findById(addressId).map(this::addressToDto).orElse(null);
    }

    @Override
    public void remove(int addressId) {
        addressRepository.deleteById(addressId);
    }

    private AddressDto addressToDto(Address address) {
        return modelMapper.map(address, AddressDto.class);
    }

    private Address dtoToAddress(AddressDto addressDto) {
        return modelMapper.map(addressDto, Address.class);
    }
}
