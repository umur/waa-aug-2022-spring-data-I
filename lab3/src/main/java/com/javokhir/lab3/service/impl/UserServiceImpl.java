package com.javokhir.lab3.service.impl;

import com.javokhir.lab3.dto.UserDto;
import com.javokhir.lab3.mapper.UserMapper;
import com.javokhir.lab3.repository.UserRepository;
import com.javokhir.lab3.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserDto create(UserDto dto) {
        return mapper.toDto(repository.save(mapper.fromDto(dto)));
    }

    @Override
    public UserDto update(UserDto dto) {
        return mapper.toDto(repository.save(mapper.fromDto(dto)));
    }

    @Override
    public List<UserDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
