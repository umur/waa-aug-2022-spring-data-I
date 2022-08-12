package com.example.waa_lab3.Repository;


import com.example.waa_lab3.Domian.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {


}
