package com.miu.Lab3.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miu.Lab3.entity.User;
import com.miu.Lab3.service.UserService;
import com.miu.Lab3.repository.UserRepository;



/**
 * @author laithnassar
 *
 */
@Service
public class UserServiceImpl implements UserService {
    
    
    @Autowired
    private UserRepository UserRepository;

    @Override
    public List<User> findAll() {
        var result = new ArrayList<User>();
        UserRepository.findAll().forEach(s -> result.add(s));
        return result;
        
    }    
    
    

}
