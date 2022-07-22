package edu.miu.lab3.joincolumn_bidir.repository;

import edu.miu.lab3.joincolumn_bidir.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findAllByProductId(int id);
}
