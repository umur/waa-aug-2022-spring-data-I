package com.miu.Lab3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.miu.Lab3.entity.Product;


/**
 * @author laithnassar
 *
 */

public interface ProductService {
    
    List<Product> findAll();
    

}
