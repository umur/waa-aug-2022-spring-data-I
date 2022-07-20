package com.miu.Lab3.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miu.Lab3.entity.Product;
import com.miu.Lab3.service.ProductService;
import com.miu.Lab3.repository.ProductRepository;



/**
 * @author laithnassar
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
    
    
    @Autowired
    private ProductRepository ProductRepository;

    @Override
    public List<Product> findAll() {
        var result = new ArrayList<Product>();
        ProductRepository.findAll().forEach(s -> result.add(s));
        return result;
        
    }    
    
    

}
