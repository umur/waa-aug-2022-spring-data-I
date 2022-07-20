package waa.lab3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import waa.lab3.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
}
