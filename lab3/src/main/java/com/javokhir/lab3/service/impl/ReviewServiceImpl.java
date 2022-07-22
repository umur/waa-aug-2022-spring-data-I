package com.javokhir.lab3.service.impl;

import com.javokhir.lab3.dto.ReviewDto;
import com.javokhir.lab3.mapper.ReviewMapper;
import com.javokhir.lab3.repository.ReviewRepository;
import com.javokhir.lab3.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;
    private final ReviewMapper mapper;

    @Override
    public ReviewDto create(ReviewDto dto) {
        return mapper.toDto(repository.save(mapper.fromDto(dto)));
    }

    @Override
    public ReviewDto update(ReviewDto dto) {
        return mapper.toDto(repository.save(mapper.fromDto(dto)));
    }

    @Override
    public List<ReviewDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ReviewDto getById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ReviewDto> getAllByProductId(Long productId) {
        return repository.findAllByProductId(productId).stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
