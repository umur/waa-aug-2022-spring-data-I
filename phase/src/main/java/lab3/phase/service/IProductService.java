package lab3.phase.service;

import lab3.phase.dto.ProductDTO;
import lab3.phase.entity.Category;
import lab3.phase.entity.Product;

import java.util.List;

public interface IProductService extends ICRUDService<ProductDTO>{
    List<ProductDTO> findProductByPriceGreaterThan(float price);
    List<ProductDTO> findProductByCategoryAndPriceLessThan(int catId, float price);
    List<ProductDTO> findProductByNameContaining(String name);
}
