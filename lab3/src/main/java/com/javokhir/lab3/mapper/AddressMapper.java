package com.javokhir.lab3.mapper;

import com.javokhir.lab3.domain.Address;
import com.javokhir.lab3.dto.AddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface AddressMapper {

    Address fromDto(AddressDto dto);

    @Mapping(target = "user", qualifiedByName = "excludeRelationsUser")
    AddressDto toDto(Address address);

    @Named("excludeUser")
    @Mapping(target = "user", ignore = true)
    AddressDto excludeUser(Address address);
}
