package com.miu.spring.data.repository;

import com.miu.spring.data.entity.Category;
import org.modelmapper.Converters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
