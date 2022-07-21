package com.javokhir.lab3.mapper;

import com.javokhir.lab3.domain.Address;
import com.javokhir.lab3.dto.AddressDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address fromDto(AddressDto dto);

    AddressDto toDto(Address address);
}
