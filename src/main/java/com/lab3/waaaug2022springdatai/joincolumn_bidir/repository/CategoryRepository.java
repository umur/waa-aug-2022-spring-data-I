package com.lab3.waaaug2022springdatai.joincolumn_bidir.repository;

import com.lab3.waaaug2022springdatai.joincolumn_bidir.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
