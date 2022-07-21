package cs545waa.lab3.repository;

import cs545waa.lab3.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
}
