package edu.miu.lab3.joincolumn_bidir.service;

import edu.miu.lab3.joincolumn_bidir.dto.ProductDto;
import edu.miu.lab3.joincolumn_bidir.entity.Product;

import java.util.List;

public interface ProductService {
    Product save(ProductDto productDto);

    void delete(int id);

    Product getById(int id);

    List<Product> getAll();

    Product updateProduct(Product product);

    List<Product> findAllByPriceGreaterThan(double minCost);

    List<Product> findAllByPriceLessThanAndCategory(double price, int cat);

    List<Product> findByCategory(String keyword);
}
