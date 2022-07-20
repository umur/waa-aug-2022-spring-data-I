package miu.edu.lab03.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.lab03.dto.AddressDTO;
import miu.edu.lab03.model.Address;
import miu.edu.lab03.service.AddressServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressServiceImpl service;

    private final ModelMapper mapper;

    @GetMapping
    public List<AddressDTO> getAll() {
        return service.getAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(this::toDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public AddressDTO save(@RequestBody Address address) {
        return this.toDTO(service.save(address));
    }

    @PutMapping("/{id}")
    public AddressDTO update(@PathVariable Long id, @RequestBody Address address) {
        address.setId(id);
        return this.toDTO(service.save(address));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    private AddressDTO toDTO(Address address) {
        return mapper.map(address, AddressDTO.class);
    }

    private Address toEntity(AddressDTO address) {
        return mapper.map(address, Address.class);
    }
}
