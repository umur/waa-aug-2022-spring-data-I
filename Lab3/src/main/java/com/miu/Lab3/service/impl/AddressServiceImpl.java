package com.miu.Lab3.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miu.Lab3.entity.Address;
import com.miu.Lab3.service.AddressService;
import com.miu.Lab3.repository.AddressRepository;



/**
 * @author laithnassar
 *
 */
@Service
public class AddressServiceImpl implements AddressService {
    
    
    @Autowired
    private AddressRepository AddressRepository;

    @Override
    public List<Address> findAll() {
        var result = new ArrayList<Address>();
        AddressRepository.findAll().forEach(s -> result.add(s));
        return result;
        
    }    
    
    

}
