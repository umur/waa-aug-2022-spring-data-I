package com.example.waa_lab3.Repository;

import com.example.waa_lab3.DTO.CategoryDto;
import com.example.waa_lab3.Domian.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {



}
