package com.lab3.waaaug2022springdatai.joincolumn_unidir.repository;

import com.lab3.waaaug2022springdatai.joincolumn_unidir.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
