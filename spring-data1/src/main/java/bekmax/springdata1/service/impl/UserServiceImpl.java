package bekmax.springdata1.service.impl;

import bekmax.springdata1.dto.UserDto;
import bekmax.springdata1.model.Address;
import bekmax.springdata1.model.User;
import bekmax.springdata1.repository.AddressRepository;
import bekmax.springdata1.repository.UserRepository;
import bekmax.springdata1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Override
    public List<UserDto> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(this::convertUserToDto)
                .toList();
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = userRepository.save(convertDtoToUser(userDto));
        userDto.setId(user.getId());
        return userDto;
    }

    @Override
    public UserDto get(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(this::convertUserToDto).orElse(null);
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    private UserDto convertUserToDto(User user) {
        return new UserDto(user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getFirstname(),
                user.getLastname(),
                user.getAddress().getId());
    }

    private User convertDtoToUser(UserDto userDto) {
        Optional<Address> address = addressRepository.findById(userDto.getAddressId());
        if (address.isPresent()) {
            return new User(userDto.getId(),
                    userDto.getEmail(),
                    userDto.getPassword(),
                    userDto.getFirstName(),
                    userDto.getLastName(),
                    address.get());
        }
        throw new RuntimeException("Address not found");
    }
}
