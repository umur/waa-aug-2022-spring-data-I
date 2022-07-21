package lab3.controller;

import lab3.dto.CategoryDto;
import lab3.dto.ProductDto;
import lab3.dto.QueryDto;
import lab3.entity.Product;
import lab3.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/products")
    public List<Product> findAllProducts(@RequestParam(name = "minPrice") double minPrice, @RequestParam(name = "maxPrice") double maxPrice,
                                         @RequestParam(name = "cat") String category, @RequestParam(name = "keyword") String keyword){
        QueryDto query = new QueryDto(minPrice, maxPrice, category, keyword);
        return productService.findAllProducts(query);
    }

    @GetMapping("/products/{id}")
    public List<ProductDto> findAllProductsByUserId(@PathVariable(name = "id") int userId){
        return productService.findAllProductsByUserId(userId);
    }

    @PostMapping("/product")
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable int id) throws Exception {
        productService.deleteProductById(id);
    }

//    @PutMapping("/product")
//    public Product updateProduct(@RequestBody ProductDto product) throws Exception {
//        return productService.updateProduct(product);
//    }

    @PostMapping("/category")
    public CategoryDto createProduct(@RequestBody CategoryDto categoryDto){
        return productService.createCategory(categoryDto);
    }
}
