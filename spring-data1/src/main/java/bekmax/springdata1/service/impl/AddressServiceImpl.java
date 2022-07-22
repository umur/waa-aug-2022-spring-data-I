package bekmax.springdata1.service.impl;

import bekmax.springdata1.dto.AddressDto;
import bekmax.springdata1.dto.UserDto;
import bekmax.springdata1.model.Address;
import bekmax.springdata1.model.User;
import bekmax.springdata1.repository.AddressRepository;
import bekmax.springdata1.repository.UserRepository;
import bekmax.springdata1.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    @Override
    public List<AddressDto> findAll() {
        return addressRepository.findAll().stream().map(this::convertAddressToDto).toList();
    }

    @Override
    public AddressDto save(AddressDto addressDto) {
        Address address = addressRepository.save(convertDtoToAddress(addressDto));
        addressDto.setId(address.getId());
        return addressDto;
    }

    @Override
    public AddressDto get(Long addressId) {
        Optional<Address> address = addressRepository.findById(addressId);
        return address.map(this::convertAddressToDto).orElse(null);
    }

    @Override
    public void delete(Long addressId) {
        addressRepository.deleteById(addressId);
    }

    private AddressDto convertAddressToDto(Address address) {
        return new AddressDto(address.getId(),
                address.getStreet(),
                address.getZip(),
                address.getCity());
    }

    private Address convertDtoToAddress(AddressDto addressDto) {
            return new Address(addressDto.getId(),
                    addressDto.getStreet(),
                    addressDto.getZip(),
                    addressDto.getCity());
    }
}
