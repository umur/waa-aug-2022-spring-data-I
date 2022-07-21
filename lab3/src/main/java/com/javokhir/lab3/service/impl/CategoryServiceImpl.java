package com.javokhir.lab3.service.impl;

import com.javokhir.lab3.dto.CategoryDto;
import com.javokhir.lab3.mapper.CategoryMapper;
import com.javokhir.lab3.repository.CategoryRepository;
import com.javokhir.lab3.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    public CategoryDto create(CategoryDto dto) {
        return mapper.toDto(repository.save(mapper.fromDto(dto)));
    }

    @Override
    public CategoryDto update(CategoryDto dto) {
        return mapper.toDto(repository.save(mapper.fromDto(dto)));
    }

    @Override
    public List<CategoryDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDto getById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
