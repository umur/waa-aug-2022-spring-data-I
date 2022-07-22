package edu.miu.waa575.lab3springdata.service;

import edu.miu.waa575.lab3springdata.dto.ProductDto;
import edu.miu.waa575.lab3springdata.dto.ReviewDto;
import edu.miu.waa575.lab3springdata.entity.Product;
import edu.miu.waa575.lab3springdata.entity.Review;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    ProductDto findById(int productId);
    ProductDto save(ProductDto productDto);
    Product update(Product product);
    void remove(int productId);


    //FILTERS

    List<ProductDto> filterByMinPrice(Double price);

    List<ProductDto> filterByCatAndMaxPrice(int catId, Double price);

    List<ProductDto> filterByKeyword(String keyword);
}
