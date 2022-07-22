package edu.miu.waa575.lab3springdata.controller;


import edu.miu.waa575.lab3springdata.dto.AddressDto;
import edu.miu.waa575.lab3springdata.entity.Address;
import edu.miu.waa575.lab3springdata.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {
    private  final AddressService addressService;

    @GetMapping
    public List<AddressDto> findAll(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public  AddressDto findById(@PathVariable int id){
        return addressService.findById(id);
    }

    @PostMapping
    public  AddressDto save(@RequestBody AddressDto addressDto){
        return addressService.save(addressDto);
    }

    @PutMapping
    public  Address update(@RequestBody Address address){
        return addressService.update(address);
    }

    @DeleteMapping("/{id}")
    public  void remove(@PathVariable int id){
         addressService.remove(id);
    }

}
