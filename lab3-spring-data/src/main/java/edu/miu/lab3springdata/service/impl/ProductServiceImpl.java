package edu.miu.lab3springdata.service.impl;

import edu.miu.lab3springdata.dto.ProductDto;
import edu.miu.lab3springdata.entity.Product;
import edu.miu.lab3springdata.repository.ProductRepo;
import edu.miu.lab3springdata.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(ProductDto productDto) {
        productRepo.save(modelMapper.map(productDto, Product.class));
    }

    @Override
    public List<ProductDto> findAll() {
        var products = new ArrayList<ProductDto>();
        productRepo.findAll().forEach(p -> products.add(modelMapper.map(p, ProductDto.class)));
        return products;
    }

    @Override
    public ProductDto findById(int id) {
        var product = productRepo.findById(id).orElse(null);
        return product != null ? modelMapper.map(product, ProductDto.class) : null;
    }

    @Override
    public List<ProductDto> findAllByPriceGreaterThanEqual(float minPrice) {
        var products = productRepo.findAllByPriceGreaterThanEqual(minPrice);
        return products.stream().map(p -> modelMapper.map(p, ProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findAllByCategoryIdAndPriceLessThanEqual(int categoryId, float maxPrice) {
        var products = productRepo.findAllByCategoryIdAndPriceLessThanEqual(categoryId, maxPrice);
        return products.stream().map(p -> modelMapper.map(p, ProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findAllByNameIsLikeIgnoreCase(String keyword) {
        var products = productRepo.findAllByNameIsLikeIgnoreCase("%" + keyword + "%");
        return products.stream().map(p -> modelMapper.map(p, ProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public void update(ProductDto productDto) {
        if(productRepo.existsById(productDto.getId()))
            save(productDto);
    }

    @Override
    public void delete(int id) {
        var product = productRepo.findById(id).orElse(null);
        if(product != null)
            productRepo.delete(product);
    }
}
