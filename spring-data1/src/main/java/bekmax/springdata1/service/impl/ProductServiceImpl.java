package bekmax.springdata1.service.impl;

import bekmax.springdata1.dto.CategoryDto;
import bekmax.springdata1.dto.ProductDto;
import bekmax.springdata1.model.Category;
import bekmax.springdata1.model.Product;
import bekmax.springdata1.repository.CategoryRepository;
import bekmax.springdata1.repository.ProductRepository;
import bekmax.springdata1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(this::convertProductToDto).toList();
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = productRepository.save(convertDtoToProduct(productDto));
        productDto.setId(product.getId());
        return productDto;
    }

    @Override
    public ProductDto get(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        return product.map(this::convertProductToDto).orElse(null);
    }

    @Override
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<ProductDto> filterByGreaterThanMinPrice(Double minPrice) {
        return findAll().stream().filter(p -> p.getPrice().compareTo(minPrice) > 0).toList();
    }

    @Override
    public List<ProductDto> filterByCategoryAndLessThanMaxPrice(Long categoryId, Double maxPrice) {
        return findAll()
                .stream()
                .filter(p -> p.getCategoryId().equals(categoryId))
                .filter(p -> p.getPrice().compareTo(maxPrice) < 0)
                .toList();
    }

    @Override
    public List<ProductDto> filterByKeyword(String keyword) {
        return findAll()
                .stream()
                .filter(p->p.getName().contains(keyword))
                .toList();
    }

    private ProductDto convertProductToDto(Product product) {
        return new ProductDto(product.getId(),
                product.getName(),
                product.getPrice(),
                product.getRating(),
                product.getCategory().getId());
    }

    private Product convertDtoToProduct(ProductDto productDto) {
        Optional<Category> category = categoryRepository.findById(productDto.getCategoryId());
        if (category.isPresent()) {
            return new Product(productDto.getId(),
                    productDto.getName(),
                    productDto.getPrice(),
                    productDto.getRating(),
                    category.get());
        } else {
            throw new RuntimeException("Category does not exist");
        }
    }
}
