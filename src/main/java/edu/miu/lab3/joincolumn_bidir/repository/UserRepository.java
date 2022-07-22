package edu.miu.lab3.joincolumn_bidir.repository;

import edu.miu.lab3.joincolumn_bidir.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
