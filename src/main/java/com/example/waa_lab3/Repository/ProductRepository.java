package com.example.waa_lab3.Repository;

import com.example.waa_lab3.Domian.Product;
import com.example.waa_lab3.Domian.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findByPriceGreaterThan(Double minPrice);
//    List<Product> findAllByCategory

//    @Query("SELECT p FROM Product p JOIN p.category c where c.id = ?1 and  p.price = ?2")
//    List<Product> findByCategoryAndPriceLessThan(Integer category_id , Double maxPrice);
    List<Product> findByNameContains(String keyword) ;
//
//    @Query(value = "SELECT r FROM Product p JOIN p.reviews r where p.id = ?1")
//    List<Review> findAllReviewsOfProduct(Integer productId);

    public List<Product> findAllByCategoryIdAndPriceLessThanEqual(int categoryId, double maxPrice);
//



}
