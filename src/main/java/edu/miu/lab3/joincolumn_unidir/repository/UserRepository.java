package edu.miu.lab3.joincolumn_unidir.repository;

import edu.miu.lab3.joincolumn_unidir.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
