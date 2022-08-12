package com.example.waa_lab3;

import com.example.waa_lab3.Domian.*;
import com.example.waa_lab3.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class StartUpRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final AddressRepository addressRepository;


    @Transactional
    public void run(String... args) throws Exception {

        Address a1 = new Address("1000 4th Street" , 52557 , "Fair Field");
        Address a2 = new Address("King George Street" , 67897 , "Addis Ababa");
        User user1 = new User("megdiwg@gmail.com" , "Klaklk" , "Hanna" , "Kedir");
        user1.setAddress(a1);
        User user2 = new User("megdiwg@gmail.com" , "Klaklk" , "Alemu" , "Bekele");
        user2.setAddress(a2);

        Review review1 = new Review("True to size");
        review1.setUser(user1);
        Review review2 = new Review("Amazing");
        review2.setUser(user1);
        Review review3 = new Review("Poor");
        review3.setUser(user2);
        Review review4 = new Review("Excellent product");
        review4.setUser(user2);
        user1.setReviews(Arrays.asList(review1 , review2));
        user2.setReviews(Arrays.asList(review3 , review4));

        Category category1 = new Category("Electronics");
        Category category2 = new Category("Fabric");

        Product product1 = new Product();
        product1.setName("TV");
        product1.setPrice(6786);
        product1.setRating(3.5);

        product1.setCategory(category1);
        Product product2 = new Product("AirPod" , 210 , 4.5);
        product1.setName("TV");
        product1.setPrice(6786);
        product1.setRating(3.5);

        product2.setCategory(category1);
        Product product3 = new Product("T-Shirt" , 25 , 2.5);
        product3.setCategory(category2);
        Product product4 = new Product("Shorts" , 12 , 5.0);
        product4.setCategory(category2);

        category1.setProducts(Arrays.asList(product1 , product2));
        category2.setProducts(Arrays.asList(product3 , product4));


        product1.addReview(review1);
        product2.addReview(review2);
        product3.addReview(review3);
        product4.addReview(review4);

        user1.addReview(review1);
        user1.addReview(review4);

        user2.addReview(review2);
        user2.addReview(review3);

        user1.setProducts(Arrays.asList(product1 , product2));
        user2.setProducts(Arrays.asList(product3 , product4));

        review1.setProduct(product1);
        review2.setProduct(product2);
        review3.setProduct(product3);
        review4.setProduct(product4);


        product1.setUser(user1);
        product2.setUser(user1);
        product3.setUser(user2);
        product4.setUser(user2);

        addressRepository.save(a1);
        addressRepository.save(a2);

        categoryRepository.save(category1);
        categoryRepository.save(category2);

        userRepository.save(user1);
        userRepository.save(user2);

        reviewRepository.save(review1);
        reviewRepository.save(review2);
        reviewRepository.save(review3);
        reviewRepository.save(review4);


        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product3);


    }
}
