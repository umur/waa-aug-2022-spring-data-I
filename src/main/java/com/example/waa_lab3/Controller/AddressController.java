package com.example.waa_lab3.Controller;

import com.example.waa_lab3.DTO.AddressDto;
import com.example.waa_lab3.Service.Imp.AddressService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private final AddressService addressService;

    @GetMapping
    public List<AddressDto> findAll(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")

    public AddressDto getAddress(@PathVariable("id") int id){

        return addressService.getAddress(id);
    }

    @PostMapping()

    public AddressDto address(@RequestBody AddressDto addressDto){

        return addressService.addAddress(addressDto);

    }

    @PutMapping("/{id}")
    public AddressDto updateAddress(@RequestBody AddressDto addressDto, @PathVariable int id){

        return addressService.updateAddress(addressDto,id);

    }

    @DeleteMapping("/{id}")

    public void deleteAddress(@PathVariable("id") int id){

        addressService.deleteAddress(id);

    }


}
