package edu.miu.lab3.service.implementation;

import edu.miu.lab3.dto.CategoryDto;
import edu.miu.lab3.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Override
    public List<CategoryDto> fetchAll() {
        return null;
    }
}
