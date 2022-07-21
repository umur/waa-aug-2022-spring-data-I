package miu.edu.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.UserDto;
import miu.edu.entity.Address;
import miu.edu.entity.User;
import miu.edu.repository.AddressRepository;
import miu.edu.repository.UserRepository;
import miu.edu.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(this::userToDto).collect(Collectors.toList());
    }

    @Override
    public UserDto save(UserDto userDto) {
        userRepository.save(dtoToUser(userDto));
        return userDto;
    }

    @Override
    public UserDto getOne(int userId) {
        return userRepository.findById(userId).map(this::userToDto).orElse(null);
    }

    @Override
    public void remove(int userId) {
        userRepository.deleteById(userId);
    }

    private UserDto userToDto(User user) {
        return new UserDto(user.getId(), user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getAddress().getId());
    }

    private User dtoToUser(UserDto userDto) {
        Optional<Address> address = addressRepository.findById(userDto.getAddressId());
        if (!address.isPresent())
            throw new RuntimeException("Address not found");
        return new User(userDto.getId(), userDto.getEmail(), userDto.getPassword(), userDto.getFirstName(), userDto.getLastName(), address.get());
    }
}
