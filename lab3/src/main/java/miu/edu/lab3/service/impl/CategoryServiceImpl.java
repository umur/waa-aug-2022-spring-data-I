package miu.edu.lab3.service.impl;

import miu.edu.lab3.dto.*;
import miu.edu.lab3.entity.Category;
import miu.edu.lab3.entity.Product;
import miu.edu.lab3.repo.CategoryRepo;
import miu.edu.lab3.repo.ProductRepo;
import miu.edu.lab3.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepo repository;
    private ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepo repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoryDto> getAll() {
        var entity = repository.findAll();
        List<CategoryDto> result = new ArrayList<>();
        entity.forEach(e-> result.add(modelMapper.map(e, CategoryDto.class)));
        return result;
    }

    @Override
    public CategoryDetailsDto getById(int id) {
        var entity = repository.findById(id);
        if(entity.isPresent()==false)
            return null;
        var result = modelMapper.map(entity.get(), CategoryDetailsDto.class);
        return result;
    }

    @Override
    public void save(CategoryCreateDto cat) {
        var entity = modelMapper.map(cat, Category.class);
        repository.save(entity);

    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(int id, CategoryCreateDto cat) throws Exception {
        var entity = modelMapper.map(cat, Category.class);
        var existing = repository.findById(id);

        if(existing.isPresent()==false){
            throw new Exception("Entity not found");
        }
        entity.setId(id);
        repository.save(entity);

    }
}
