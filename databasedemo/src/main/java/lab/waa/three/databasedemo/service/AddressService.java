package lab.waa.three.databasedemo.service;

import lab.waa.three.databasedemo.dto.AddressDto;
import lab.waa.three.databasedemo.dto.ReviewDto;
import lab.waa.three.databasedemo.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
  void save(AddressDto dto);

  void delete(int id);

  void update(int id, AddressDto dto);

  List<AddressDto> findAll();

  AddressDto findById(int id);
}
