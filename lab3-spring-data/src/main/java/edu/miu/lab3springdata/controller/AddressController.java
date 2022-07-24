package edu.miu.lab3springdata.controller;

import edu.miu.lab3springdata.dto.AddressDto;
import edu.miu.lab3springdata.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public void save(@RequestBody AddressDto addressDto) {
        addressService.save(addressDto);
    }

    @GetMapping
    public List<AddressDto> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public AddressDto findById(@PathVariable int id) {
        return addressService.findById(id);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody AddressDto addressDto) {
        addressDto.setId(id);
        addressService.update(addressDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        addressService.delete(id);
    }
}
