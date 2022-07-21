package lab3.service;

import lab3.dto.CategoryDto;
import lab3.dto.ProductDto;
import lab3.dto.QueryDto;
import lab3.dto.UserDto;
import lab3.entity.Category;
import lab3.entity.Product;
import lab3.entity.User;
import lab3.repository.CategoryRepo;
import lab3.repository.ProductRepo;
import lab3.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements  ProductService{
    //
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<Product> findAllProducts(QueryDto queryDto) {

        if(queryDto.getMinPrice()> 0) {
            return productRepo.findAllByPriceGreaterThan(queryDto.getMinPrice());
        }
        if(queryDto.getMaxPrice()>0 && !queryDto.getCategory().isEmpty()) {
            return productRepo.findAllByPriceLessThanAndCategoryEquals(queryDto.getMaxPrice(), queryDto.getCategory());
        }
        if (!queryDto.getKeyword().isEmpty()) {
            return productRepo.findAllByNameContainsIgnoreCase(queryDto.getKeyword());
        }

        return (List<Product>) productRepo.findAll();
    }
    public List<ProductDto> findAllProductsByUserId(int id) {
        List<Product> products = productRepo.findAllByUserId(id);
        List<ProductDto> productDtos = new ArrayList<>();

        for(Product product: products) {
            ProductDto productDto = modelMapper.map(product, ProductDto.class);
            productDto.setUserId(product.getUser().getId());
            productDto.setCategoryId(product.getCategory().getId());
            productDtos.add(productDto);

        }
        return  productDtos;
    }

    public Product findProductById(int id) {
        return productRepo.findById(id).get();
    }

    public ProductDto createProduct(ProductDto productDto) {
        Category category = categoryRepo.findById(productDto.getCategoryId()).get();
        User user = userRepo.findById(productDto.getUserId()).get();

        Product product = modelMapper.map(productDto, Product.class);
        product.setCategory(category);
        product.setUser(user);

        Product savedProduct = productRepo.save(product);
        return modelMapper.map(savedProduct, ProductDto.class);
    }

    public Product updateProduct(Product product){
        return productRepo.save(product);
    }

    public void deleteProductById(int id){
        productRepo.deleteById(id);
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        Category savedCategory = categoryRepo.save(category);
        return modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto findCategoryById(int id) {
        Category category = categoryRepo.findById(id).get();
        CategoryDto resDto = modelMapper.map(category, CategoryDto.class);
        return resDto;
    }

    @Override
    public void deleteCategoryById(int id) {
        categoryRepo.deleteById(id);
    }

}
