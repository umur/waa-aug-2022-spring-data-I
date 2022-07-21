package com.javokhir.lab3.service.impl;

import com.javokhir.lab3.dto.AddressDto;
import com.javokhir.lab3.mapper.AddressMapper;
import com.javokhir.lab3.repository.AddressRepository;
import com.javokhir.lab3.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;
    private final AddressMapper mapper;

    @Override
    public AddressDto create(AddressDto address) {
        return mapper.toDto(repository.save(mapper.fromDto(address)));
    }

    @Override
    public AddressDto update(AddressDto address) {
        return mapper.toDto(repository.save(mapper.fromDto(address)));
    }

    @Override
    public List<AddressDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public AddressDto getById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
