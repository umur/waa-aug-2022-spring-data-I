package edu.miu.lab3springdata.service;

import edu.miu.lab3springdata.dto.AddressDto;

import java.util.List;

public interface AddressService {
    public void save(AddressDto addressDto);
    public List<AddressDto> findAll();
    public AddressDto findById(int id);
    public void update(AddressDto addressDto);
    public void delete(int id);
}
