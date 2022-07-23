package lab.waa.three.databasedemo.service.impl;

import lab.waa.three.databasedemo.dto.AddressDto;
import lab.waa.three.databasedemo.mapper.AddressMapper;
import lab.waa.three.databasedemo.reposoitory.AddressRepository;
import lab.waa.three.databasedemo.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
  private final AddressRepository repository;
  private final AddressMapper mapper;

  @Override
  public void save(AddressDto dto) {
    repository.save(mapper.toModel(dto));
  }

  @Override
  public void delete(int id) {
    repository.deleteById(id);
  }

  @Override
  public void update(int id, AddressDto dto) {
    repository.save(mapper.toModel(dto));
  }

  @Override
  public List<AddressDto> findAll() {
    var result = new ArrayList<AddressDto>();
    var data = repository.findAll();

    data.forEach(d -> result.add(mapper.toDTO(d)));

    return result;
  }

  @Override
  public AddressDto findById(int id) {
    return mapper.toDTO(repository.findById(id).orElse(null));
  }
}
