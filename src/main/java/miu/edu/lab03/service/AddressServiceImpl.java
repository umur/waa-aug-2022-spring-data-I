package miu.edu.lab03.service;

import lombok.RequiredArgsConstructor;
import miu.edu.lab03.model.Address;
import miu.edu.lab03.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;

    @Override
    public List<Address> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Address> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Address save(Address address) {
        return repository.save(address);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
