package cs545waa.lab3.repository;

import cs545waa.lab3.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Integer> {
}
