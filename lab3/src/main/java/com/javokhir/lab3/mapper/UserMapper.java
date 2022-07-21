package com.javokhir.lab3.mapper;

import com.javokhir.lab3.domain.User;
import com.javokhir.lab3.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromDto(UserDto dto);

    UserDto toDto(User user);
}
