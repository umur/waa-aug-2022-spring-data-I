package com.javokhir.lab3.controller;

import com.javokhir.lab3.dto.AddressDto;
import com.javokhir.lab3.service.AddressService;
import com.javokhir.lab3.service.CrudService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/addresses")
public class AddressController implements CrudController<AddressDto, Long> {

    private final AddressService service;

    @Override
    public CrudService<AddressDto, Long> getService() {
        return service;
    }
}
