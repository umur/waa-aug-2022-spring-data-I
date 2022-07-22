package edu.miu.waa575.lab3springdata.repository;

import edu.miu.waa575.lab3springdata.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
