package com.example.waa_lab3.Service;

import com.example.waa_lab3.DTO.ProductDto;
import com.example.waa_lab3.Domian.Product;
import com.example.waa_lab3.Domian.Review;

import java.util.List;

public interface IProductService {

    List<ProductDto> findAll();
    ProductDto getProduct(int id);
    ProductDto  updateProduct(ProductDto productDto, int id);
    ProductDto addProduct(int categoryId, ProductDto productDto);
    void deleteProduct(int id);
    List<Product> findByPriceGreaterThan(Double minPrice);
    List<Product> findByCategoryAndPriceLessThan(Integer category_id , Double maxPrice);
    List<ProductDto> findByNameContains(String keyword) ;
    public List<Review> findAllReviewsOfProduct(Integer productId) ;

    public List<ProductDto> findAllByCategoryIdAndPriceLessThanEqual(int categoryId, double maxPrice);
}
