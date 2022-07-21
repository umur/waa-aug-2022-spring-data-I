package lab3.service;

import lab3.dto.CategoryDto;
import lab3.dto.ProductDto;
import lab3.dto.QueryDto;
import lab3.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> findAllProducts(QueryDto queryDto);
    public Product findProductById(int id);
    public ProductDto createProduct(ProductDto productDto);
    public Product updateProduct(Product product);
    public void deleteProductById(int id);

    public CategoryDto createCategory(CategoryDto categoryDto);

    public CategoryDto findCategoryById(int id);

    public void deleteCategoryById(int id);

}
