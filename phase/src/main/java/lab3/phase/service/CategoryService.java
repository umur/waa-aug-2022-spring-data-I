package lab3.phase.service;

import lab3.phase.dto.AddressDTO;
import lab3.phase.dto.CategoryDTO;
import lab3.phase.entity.Address;
import lab3.phase.entity.Category;
import lab3.phase.repository.ICategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    private ICategoryRepository repo;
    private ModelMapper mapper;

    @Autowired
    public CategoryService(ICategoryRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public CategoryDTO createOrUpdate(CategoryDTO item) {
        return mapper.map(repo.save(mapper.map(item, Category.class)), CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> read() {
        var data = repo.findAll();
        List<CategoryDTO> result = new ArrayList<>();
        data.forEach(e -> result.add(mapper.map(e, CategoryDTO.class)));
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
