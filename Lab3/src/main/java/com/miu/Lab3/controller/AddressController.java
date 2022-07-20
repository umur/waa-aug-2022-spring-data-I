package com.miu.Lab3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miu.Lab3.entity.Address;
import com.miu.Lab3.service.AddressService;


@RestController("/Address")
public class AddressController {

    @Autowired
    private AddressService AddressService;

    @GetMapping
    public List<Address> findAll() {
        return AddressService.findAll();
    }


}
