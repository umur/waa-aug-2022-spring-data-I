package waa.lab3.service.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import waa.lab3.dto.AddressDto;
import waa.lab3.entity.Address;
import waa.lab3.repository.AddressRepo;
import waa.lab3.service.AddressService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;

    private final ModelMapper modelMapper;

    @Override
    public List<AddressDto> findAll() {
        var result = new ArrayList<AddressDto>();
        addressRepo.findAll().forEach(address -> result.add(modelMapper.map(address, AddressDto.class)));
        return result;
    }

    @Override
    public AddressDto findById(int id) {
        return modelMapper.map(addressRepo.findById(id).get(), AddressDto.class);
    }

    @Override
    public void deleteById(int id) {
        addressRepo.deleteById(id);
    }

    @Override
    public void saveAddress(AddressDto add) {
        addressRepo.save(modelMapper.map(add, Address.class));
    }
}
