package lab.waa.three.databasedemo.mapper;

import lab.waa.three.databasedemo.dto.AddressDto;
import lab.waa.three.databasedemo.dto.CategoryDto;
import lab.waa.three.databasedemo.entity.Address;
import lab.waa.three.databasedemo.entity.Category;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressMapper {
  private final ModelMapper modelMapper;

  public AddressDto toDTO(Address model) {
    return modelMapper.map(model, AddressDto.class);
  }

  public Address toModel(AddressDto dto) {
    return modelMapper.map(dto, Address.class);
  }
}
