package edu.miu.waa575.lab3springdata.service.impl;

import edu.miu.waa575.lab3springdata.dto.CategoryDto;
import edu.miu.waa575.lab3springdata.dto.ProductDto;
import edu.miu.waa575.lab3springdata.entity.Category;
import edu.miu.waa575.lab3springdata.entity.Product;
import edu.miu.waa575.lab3springdata.repository.CategoryRepository;
import edu.miu.waa575.lab3springdata.repository.ProductRepository;
import edu.miu.waa575.lab3springdata.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    private final CategoryRepository categoryRepository;

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(int productId) {
        return productRepository.findById(productId).map(this::toDto).orElse(null);
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        productRepository.save(dtoToEntity(productDto));
        return  productDto;
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(int productId) {
       productRepository.deleteById(productId);
    }




    @Override
    public List<ProductDto> filterByMinPrice(Double price) {
        return productRepository.findAllByPriceGreaterThan(price).stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> filterByCatAndMaxPrice(int catId, Double price) {
        Optional<Category> category = categoryRepository.findById(catId);
        if (!category.isPresent())
            return Collections.emptyList();
        return productRepository.findAllByCategoryAndPriceLessThan((jdk.jfr.Category) category.get(), price).stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> filterByKeyword(String keyword) {
        return productRepository.findAllByNameContaining(keyword).stream().map(this::toDto).collect(Collectors.toList());
    }




    //MappeR
    private ProductDto toDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    private Product dtoToEntity(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }


}
