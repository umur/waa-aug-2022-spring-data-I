package edu.miu.lab3.joincolumn_unidir.repository;

import edu.miu.lab3.joincolumn_unidir.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
