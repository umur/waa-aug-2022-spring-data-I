package edu.miu.lab3springdata.service.impl;

import edu.miu.lab3springdata.dto.AddressDto;
import edu.miu.lab3springdata.entity.Address;
import edu.miu.lab3springdata.repository.AddressRepo;
import edu.miu.lab3springdata.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(AddressDto addressDto) {
        addressRepo.save(modelMapper.map(addressDto, Address.class));
    }

    @Override
    public List<AddressDto> findAll() {
        var addresses = new ArrayList<AddressDto>();
        addressRepo.findAll().forEach(c -> addresses.add(modelMapper.map(c, AddressDto.class)));
        return addresses;
    }

    @Override
    public AddressDto findById(int id) {
        var address = addressRepo.findById(id).orElse(null);
        return address != null ? modelMapper.map(address, AddressDto.class) : null;
    }

    @Override
    public void update(AddressDto addressDto) {
        if(addressRepo.existsById(addressDto.getId()))
            save(addressDto);
    }

    @Override
    public void delete(int id) {
        var address = addressRepo.findById(id).orElse(null);
        if(address != null)
            addressRepo.delete(address);
    }
}
