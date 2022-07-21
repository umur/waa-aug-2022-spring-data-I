package lab3.phase.service;

import lab3.phase.dto.ProductDTO;
import lab3.phase.entity.Product;
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

    @Autowired
    public ProductService(IProductRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
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
}
