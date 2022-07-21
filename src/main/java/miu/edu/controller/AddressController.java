package miu.edu.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.AddressDto;
import miu.edu.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public List<AddressDto> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public AddressDto getOne(@PathVariable Integer id) {
        return addressService.getOne(id);
    }

    @PostMapping
    public AddressDto save(@RequestBody AddressDto addressDto) {
        return addressService.save(addressDto);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Integer id) {
        addressService.remove(id);
    }
}
