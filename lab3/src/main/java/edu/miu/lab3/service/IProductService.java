package edu.miu.lab3.service;


import edu.miu.lab3.dto.ProductDto;
import edu.miu.lab3.entity.Product;


import java.util.List;

public interface IProductService {

    List<ProductDto> fetchAll();

    List<ProductDto> findAllByPriceGreaterThan(double price);

    List<ProductDto> findAllByCategoryAndPriceLessThan(String category, double price);
    List<ProductDto> findAllByNameContainingIgnoreCase(String keyword);
}
