/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service.impl;

import com.nhom21.pojo.User;
import com.nhom21.repository.UserRepository;
import com.nhom21.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WIN10
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepo;
    
    @Override
    public List<User> getUserById() {
        return this.userRepo.getUserById();
    }
    
}
