package edu.miu.lab3.service;

import edu.miu.lab3.dto.CategoryDto;

import java.util.List;

public interface ICategoryService {

    List<CategoryDto> fetchAll();
}
