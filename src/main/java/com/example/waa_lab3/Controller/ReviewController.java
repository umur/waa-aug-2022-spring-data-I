package com.example.waa_lab3.Controller;


import com.example.waa_lab3.DTO.ReviewDto;
import com.example.waa_lab3.Service.Imp.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@AllArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private final ReviewService ReviewService;


    @GetMapping
    public List<ReviewDto> findAll(){
        return ReviewService.findAll();
    }

    @GetMapping("/id")
        public ReviewDto getReview(int id){

            return ReviewService.getReview(id);
    }

    @PostMapping(" ")



}
