package miu.edu.lab03.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.lab03.dto.ProductDTO;
import miu.edu.lab03.model.Product;
import miu.edu.lab03.service.ProductServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl service;

    private final ModelMapper mapper;

    @GetMapping
    public List<ProductDTO> getAll() {
        return service.getAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(this::toDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ProductDTO save(@RequestBody Product product) {
        return this.toDTO(service.save(product));
    }

    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return this.toDTO(service.save(product));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("filter-by-min-price")
    public List<ProductDTO> getByMinPrice(@RequestParam Double price) {
        return service.findProductsByPriceGreaterThan(price)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("filter-by-category-and-max-price")
    public List<ProductDTO> getByCategoryAndMaxPrice(@RequestParam Long id, @RequestParam Double price) {
        return service.findProductsByCategoryAndPriceLessThan(id, price)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("filter-by-word")
    public List<ProductDTO> getByMinPrice(@RequestParam String word) {
        return service.findProductsByNameContains(word)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO toDTO(Product product) {
        return mapper.map(product, ProductDTO.class);
    }

    private Product toEntity(ProductDTO product) {
        return mapper.map(product, Product.class);
    }
}
