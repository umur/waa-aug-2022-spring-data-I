package com.javokhir.lab3.service.impl;

import com.javokhir.lab3.dto.ProductDto;
import com.javokhir.lab3.mapper.ProductMapper;
import com.javokhir.lab3.repository.ProductRepository;
import com.javokhir.lab3.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public ProductDto create(ProductDto dto) {
        return mapper.toDto(repository.save(mapper.fromDto(dto)));
    }

    @Override
    public ProductDto update(ProductDto dto) {
        return mapper.toDto(repository.save(mapper.fromDto(dto)));
    }

    @Override
    public List<ProductDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto getById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ProductDto> getByMinPrice(Double minPrice) {
        return repository.findAllByMinPrice(minPrice).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getByCategoryAndMaxPrice(Long categoryId, double maxPrice) {
        return repository.findAllByCategoryIdAndMaxPrice(categoryId, maxPrice).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getByName(String name) {
        return repository.findProductsByNameContainingIgnoreCase(name).stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
