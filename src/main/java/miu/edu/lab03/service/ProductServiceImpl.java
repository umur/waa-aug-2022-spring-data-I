package miu.edu.lab03.service;

import lombok.RequiredArgsConstructor;
import miu.edu.lab03.model.Product;
import miu.edu.lab03.repository.CategoryRepository;
import miu.edu.lab03.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    private final CategoryRepository categoryRepository;

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Product> findProductsByPriceGreaterThan(Double price) {
        return repository.findProductsByPriceGreaterThan(price);
    }

    @Override
    public List<Product> findProductsByCategoryAndPriceLessThan(Long categoryId, Double price) {
        return categoryRepository.findById(categoryId)
                .map(category -> repository.findProductsByCategoryAndPriceLessThan(category, price))
                .orElseGet(ArrayList::new);
    }

    @Override
    public List<Product> findProductsByNameContains(String word) {
        return repository.findProductsByNameContains(word);
    }
}
