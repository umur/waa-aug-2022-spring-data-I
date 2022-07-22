package edu.miu.lab3.joincolumn_bidir.service.Impl;

import edu.miu.lab3.joincolumn_bidir.dto.ProductDto;
import edu.miu.lab3.joincolumn_bidir.entity.Category;
import edu.miu.lab3.joincolumn_bidir.entity.Product;
import edu.miu.lab3.joincolumn_bidir.repository.CategoryRepository;
import edu.miu.lab3.joincolumn_bidir.repository.ProductRepository;
import edu.miu.lab3.joincolumn_bidir.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;

    @Override
    public Product save(ProductDto productDto) {
        Category category = categoryRepository.findById(productDto.getCategoryId()).orElse(null);

        Product product = modelMapper.map(productDto, Product.class);
        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAllByPriceGreaterThan(double minCost) {
        return productRepository.findAllByPriceGreaterThan(minCost);
    }

    @Override
    public List<Product> findAllByPriceLessThanAndCategory(double maxPrice, int cat) {
        return productRepository.findAllByPriceLessThanAndCategoryId(maxPrice, cat);
    }

    @Override
    public List<Product> findByCategory(String keyword) {
        return productRepository.findByCategoryContaining(keyword);
    }
}
