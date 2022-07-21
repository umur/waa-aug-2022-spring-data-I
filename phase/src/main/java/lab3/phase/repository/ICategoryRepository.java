package lab3.phase.repository;

import lab3.phase.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends CrudRepository<Category, Integer> {
}
