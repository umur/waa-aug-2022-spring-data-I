package com.example.waa_lab3.Repository;

import com.example.waa_lab3.Domian.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
