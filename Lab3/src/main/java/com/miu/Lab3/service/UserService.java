package com.miu.Lab3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.miu.Lab3.entity.User;


/**
 * @author laithnassar
 *
 *
 */

public interface UserService {
    
    List<User> findAll();
    

}
