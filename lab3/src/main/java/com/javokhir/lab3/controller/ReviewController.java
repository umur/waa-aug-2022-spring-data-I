package com.javokhir.lab3.controller;

import com.javokhir.lab3.dto.ReviewDto;
import com.javokhir.lab3.service.CrudService;
import com.javokhir.lab3.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewController implements CrudController<ReviewDto, Long> {

    private final ReviewService service;

    @Override
    public CrudService<ReviewDto, Long> getService() {
        return service;
    }
}
