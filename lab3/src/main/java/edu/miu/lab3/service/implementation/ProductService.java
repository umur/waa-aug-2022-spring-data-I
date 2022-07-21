package edu.miu.lab3.service.implementation;

import edu.miu.lab3.dto.ProductDto;
import edu.miu.lab3.repository.IProductRepository;
import edu.miu.lab3.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {

    IProductRepository productRepository;
    ModelMapper mapper;

    public ProductService(IProductRepository productRepository, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }


    @Override
    public List<ProductDto> fetchAll() {
        List<ProductDto> result = new ArrayList<>();
        productRepository
                .findAll()
                .forEach(p -> result.add(mapper.map(p, ProductDto.class)));
        return result;
    }

    @Override
    public List<ProductDto> findAllByPriceGreaterThan(double price) {
        List<ProductDto> result = new ArrayList<>();
        productRepository
                .findAllByPriceGreaterThan(price)
                .forEach(p -> result.add(mapper.map(p, ProductDto.class)));
        return result;
    }

    public List<ProductDto> findAllByCategoryAndPriceLessThan(String category, double price) {
        List<ProductDto> result = new ArrayList<>();
        productRepository
                .findAllByCategory_Name_AndPriceLessThan(category, price)
                .forEach(p -> result.add(mapper.map(p, ProductDto.class)));
        return result;
    }

    public List<ProductDto> findAllByNameContainingIgnoreCase(String keyword) {
        List<ProductDto> result = new ArrayList<>();
        productRepository
                .findAllByNameContainingIgnoreCase(keyword)
                .forEach(p -> result.add(mapper.map(p, ProductDto.class)));
        return result;
    }

}
