package bekmax.springdata1.controller;

import bekmax.springdata1.dto.AddressDto;
import bekmax.springdata1.model.Address;
import bekmax.springdata1.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public List<AddressDto> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public AddressDto get(@PathVariable Long id) {
        return addressService.get(id);
    }

    @PostMapping
    public AddressDto save(@RequestBody AddressDto addressDto) {
        return addressService.save(addressDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        addressService.delete(id);
    }

}
