package miu.edu.lab3.service.impl;

import miu.edu.lab3.dto.*;
import miu.edu.lab3.entity.Product;
import miu.edu.lab3.repo.ProductRepo;
import miu.edu.lab3.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepo repository;
    private ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepo repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDto> getAll() {
        var entity = repository.findAll();
        List<ProductDto> result = new ArrayList<>();
        entity.forEach(e-> result.add(modelMapper.map(e, ProductDto.class)));
        return result;
    }

    @Override
    public ProductDetailsDto getById(int id) {
        var entity = repository.findById(id);
        if(entity.isPresent()==false)
            return null;
        var result = modelMapper.map(entity.get(), ProductDetailsDto.class);
        return result;
    }

    @Override
    public void save(ProductCreateDto user) {
        var entity = modelMapper.map(user, Product.class);
        repository.save(entity);

    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<ProductDto> findByMinPrice(float price) {
        var products = repository.findAllByPriceGreaterThan(price);
        List<ProductDto> result = new ArrayList<>();
        products.forEach(e-> result.add(modelMapper.map(e, ProductDto.class)));
        return result;
    }

    @Override
    public List<ProductDto> findByMaxPriceAndCatName(float price, String name) {
        var products = repository.findAllByPriceLessThanAndCategoryName(price, name);
        List<ProductDto> result = new ArrayList<>();
        products.forEach(e-> result.add(modelMapper.map(e, ProductDto.class)));
        return result;
    }

    @Override
    public void update(int id, ProductCreateDto pro) throws Exception {
        var entity = modelMapper.map(pro, Product.class);
        var existing = repository.findById(id);

        if(existing.isPresent()==false){
            throw new Exception("Entity not found");
        }
        entity.setId(id);
        repository.save(entity);

    }
}
