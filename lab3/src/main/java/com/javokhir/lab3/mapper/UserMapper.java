package com.javokhir.lab3.mapper;

import com.javokhir.lab3.domain.User;
import com.javokhir.lab3.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, ReviewMapper.class})
public interface UserMapper {

    User fromDto(UserDto dto);

    @Mapping(target = "address", qualifiedByName = "excludeUser")
    @Mapping(target = "reviews", qualifiedByName = "excludeUser")
    UserDto toDto(User user);
}
