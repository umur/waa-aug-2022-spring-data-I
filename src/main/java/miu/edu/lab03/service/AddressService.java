package miu.edu.lab03.service;

import miu.edu.lab03.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> getAll();
    Optional<Address> getById(Long id);
    Address save(Address address);
    void delete(Long id);
}
