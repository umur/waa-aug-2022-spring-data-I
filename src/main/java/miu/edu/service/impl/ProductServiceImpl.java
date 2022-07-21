package miu.edu.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.ProductDto;
import miu.edu.entity.Category;
import miu.edu.entity.Product;
import miu.edu.repository.CategoryRepository;
import miu.edu.repository.ProductRepository;
import miu.edu.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(this::productToDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        productRepository.save(dtoToProduct(productDto));
        return productDto;
    }

    @Override
    public ProductDto getOne(int productId) {
        return productRepository.findById(productId).map(this::productToDto).orElse(null);
    }

    @Override
    public void remove(int productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<ProductDto> filterByMinPrice(Double price) {
        return productRepository.findAllByPriceGreaterThan(price).stream().map(this::productToDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> filterByCatAndMaxPrice(int catId, Double price) {
        Optional<Category> category = categoryRepository.findById(catId);
        if (!category.isPresent())
            return Collections.emptyList();
        return productRepository.findAllByCategoryAndPriceLessThan(category.get(), price).stream().map(this::productToDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> filterByKeyword(String keyword) {
        return productRepository.findAllByNameContaining(keyword).stream().map(this::productToDto).collect(Collectors.toList());
    }

    private ProductDto productToDto(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getRating(), product.getCategory().getId());
    }

    private Product dtoToProduct(ProductDto productDto) {
        Optional<Category> category = categoryRepository.findById(productDto.getCategoryId());
        if (!category.isPresent())
            throw new RuntimeException("Category not found");
        return new Product(productDto.getId(), productDto.getName(), productDto.getPrice(), productDto.getRating(), category.get());
    }
}
