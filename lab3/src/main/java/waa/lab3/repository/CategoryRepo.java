package waa.lab3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import waa.lab3.entity.Address;
import waa.lab3.entity.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> {
}
