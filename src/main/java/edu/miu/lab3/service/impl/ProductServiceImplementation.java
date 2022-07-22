package edu.miu.lab3.service.impl;

import edu.miu.lab3.domain.Product;
import edu.miu.lab3.dto.ProductDTO;
import edu.miu.lab3.repository.ProductRepository;
import edu.miu.lab3.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImplementation implements ProductService {

    ProductRepository productRepository;
    ModelMapper modelMapper;

    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllProductsPriceGreaterThan(Double price) {
        List<Product> products = productRepository.findByPriceGreaterThan(price);
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public List<ProductDTO> findAllProductsPriceLessThan(Double price) {
        List<Product> products = productRepository.findByPriceLessThan(price);
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(int id) {
        Product product = productRepository.findProductById(id);
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public Product addProduct(ProductDTO productDto) {
        Product product = productRepository.save(modelMapper.map(productDto, Product.class));
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public void deleteById(int id) {
      productRepository.deleteById(id);
    }
}
