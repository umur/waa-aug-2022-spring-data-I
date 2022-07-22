package lab3.phase.service;

import lab3.phase.dto.ProductDTO;
import lab3.phase.entity.Product;
import lab3.phase.repository.ICategoryRepository;
import lab3.phase.repository.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService{
    private IProductRepository repo;
    private ModelMapper mapper;
    private ICategoryRepository catRepo;

    @Autowired
    public ProductService(IProductRepository repo, ModelMapper mapper, ICategoryRepository catRepo) {
        this.repo = repo;
        this.mapper = mapper;
        this.catRepo = catRepo;
    }

    @Override
    public ProductDTO createOrUpdate(ProductDTO item) {
        return mapper.map(repo.save(mapper.map(item, Product.class)), ProductDTO.class);
    }

    @Override
    public List<ProductDTO> read() {
        var data = repo.findAll();
        List<ProductDTO> result = new ArrayList<>();
        data.forEach(e -> result.add(mapper.map(e, ProductDTO.class)));
        return result;
    }

    @Override
    public Boolean delete(int id) {
        var data = repo.findById(id);
        if (data.isPresent())
        {
            repo.delete(data.get());
            return true;
        }
        return false;
    }

    public List<ProductDTO> findProductByPriceGreaterThan(float price){
        var data = repo.findProductByPriceGreaterThan(price);
        List<ProductDTO> result = new ArrayList<>();
        data.forEach(e -> result.add(mapper.map(e, ProductDTO.class)));
        return result;
    }

    public List<ProductDTO> findProductByCategoryAndPriceLessThan(int catId, float price){
        var cat = catRepo.findById(catId);
        if (cat.isPresent())
        {
            var data = repo.findProductByCategoryAndPriceLessThan(cat.get(), price);
            List<ProductDTO> result = new ArrayList<>();
            data.forEach(e -> result.add(mapper.map(e, ProductDTO.class)));
            return result;
        }
        return null;
    }

    public List<ProductDTO> findProductByNameContaining(String name){
        var data = repo.findProductByNameContaining(name);
        List<ProductDTO> result = new ArrayList<>();
        data.forEach(e -> result.add(mapper.map(e, ProductDTO.class)));
        return result;
    }
}
