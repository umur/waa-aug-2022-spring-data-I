package edu.miu.lab3.jointable_bidir.repository;

import edu.miu.lab3.jointable_bidir.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
