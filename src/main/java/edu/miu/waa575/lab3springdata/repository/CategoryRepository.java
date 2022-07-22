package edu.miu.waa575.lab3springdata.repository;

import edu.miu.waa575.lab3springdata.entity.Category;
import edu.miu.waa575.lab3springdata.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
