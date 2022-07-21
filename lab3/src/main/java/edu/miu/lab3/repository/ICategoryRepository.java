package edu.miu.lab3.repository;

import edu.miu.lab3.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends CrudRepository<Category,Integer> {
}
