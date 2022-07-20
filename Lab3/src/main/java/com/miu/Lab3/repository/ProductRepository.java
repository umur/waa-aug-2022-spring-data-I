package com.miu.Lab3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miu.Lab3.entity.Product;


/**
 * @author laithnassar
 *
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {


}