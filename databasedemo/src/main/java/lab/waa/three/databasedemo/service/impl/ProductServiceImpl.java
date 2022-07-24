package lab.waa.three.databasedemo.service.impl;

import lab.waa.three.databasedemo.dto.ProductDto;
import lab.waa.three.databasedemo.mapper.AddressMapper;
import lab.waa.three.databasedemo.mapper.ProductMapper;
import lab.waa.three.databasedemo.reposoitory.AddressRepository;
import lab.waa.three.databasedemo.reposoitory.ProductRepository;
import lab.waa.three.databasedemo.service.AddressService;
import lab.waa.three.databasedemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
  private final ProductRepository addressRepository;
  private final ProductMapper addressMapper;

  @Override
  public void save(ProductDto dto) {
    addressRepository.save(addressMapper.toModel(dto));
  }

  @Override
  public void delete(int id) {
    addressRepository.deleteById(id);
  }

  @Override
  public void update(int id, ProductDto dto) {
    addressRepository.save(addressMapper.toModel(dto));
  }

  @Override
  public List<ProductDto> findAll() {
    var result = new ArrayList<ProductDto>();
    var data = addressRepository.findAll();

    data.forEach(d -> result.add(addressMapper.toDTO(d)));

    return result;
  }

  @Override
  public ProductDto findById(int id) {
    return addressMapper.toDTO(addressRepository.findById(id).orElse(null));
  }
}
