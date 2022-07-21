package com.lab3.waaaug2022springdatai.jointable_bidir.controller;

import com.lab3.waaaug2022springdatai.jointable_bidir.dto.AddressDto;
import com.lab3.waaaug2022springdatai.jointable_bidir.entity.Address;
import com.lab3.waaaug2022springdatai.jointable_bidir.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController (AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public Address save(@RequestBody AddressDto addressDto) {
        return addressService.save(addressDto);
    }

    @GetMapping
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable int id) {
        var address = addressService.getById(id);
        return ResponseEntity.ok(address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        addressService.delete(id);
    }

    @PutMapping
    public Address update(@RequestBody Address address) {
        return addressService.updateAddress(address);
    }
}
