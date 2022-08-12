package com.example.waa_lab3.Service.Imp;

import com.example.waa_lab3.DTO.ProductDto;
import com.example.waa_lab3.Domian.Category;
import com.example.waa_lab3.Domian.Product;
import com.example.waa_lab3.Domian.Review;
import com.example.waa_lab3.Repository.CategoryRepository;
import com.example.waa_lab3.Repository.ProductRepository;
import com.example.waa_lab3.Service.IProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<ProductDto> findAll() {
        var products = productRepository.findAll();
        var result = new ArrayList<ProductDto>();

        for (Product product : products) {
            ProductDto productDto = new ProductDto();
            productDto = modelMapper.map(product, ProductDto.class);
            result.add(productDto);
        }
        return result;
    }

    @Override
    public ProductDto getProduct(int id) {
        Product product = productRepository.findById(id).orElse(null);

        if (product != null) {
            ProductDto productDto = modelMapper.map(product, ProductDto.class);
            return productDto;
        }
        return null;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, int id) {
        Product product = productRepository.findById(id).orElse(null);

        if (product != null) {

            Product product1 = modelMapper.map(productDto, Product.class);
            Product product2 = productRepository.save(product1);
            ProductDto productDto1 = modelMapper.map(product2, ProductDto.class);
            return productDto1;
        }

        return null;
    }

    @Override
    public ProductDto addProduct(int categoryId, ProductDto productDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Category category = optionalCategory.get();

        Product product = modelMapper.map(productDto, Product.class);
        product.setCategory(category);
        Product product1 = productRepository.save(product);
        category.addProduct(product1);
        ProductDto productDto1 = modelMapper.map(product1, ProductDto.class);
        return productDto1;
    }

    @Override
    public void deleteProduct(int id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {

            productRepository.delete(product);
        }

    }

    @Override
    public List<Product> findByPriceGreaterThan(Double minPrice) {
        return productRepository.findByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> findByCategoryAndPriceLessThan(Integer category_id, Double maxPrice) {
        return null;
//        return productRepository.findByCategoryAndPriceLessThan(category_id, maxPrice);
    }

    @Override
    public List<ProductDto> findByNameContains(String keyword) {
        return productRepository.findByNameContains(keyword)
                .stream().map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
    }


    @Override
    public List<ProductDto> findAllByCategoryIdAndPriceLessThanEqual(int categoryId, double maxPrice) {
        return productRepository.findAllByCategoryIdAndPriceLessThanEqual(categoryId, maxPrice)
                .stream().map(product -> modelMapper.map(product, ProductDto.class))
                .toList();

    }

    @Override
    public List<Review> findAllReviewsOfProduct(Integer productId) {
        return null;
//        return productRepository.findAllReviewsOfProduct(productId);
    }

}
