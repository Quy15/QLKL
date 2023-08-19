/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom21.service;

import com.nhom21.pojo.User;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author WIN10
 */
public interface UserService extends UserDetailsService{
    List<User> getUser(Map<String, String> params);
    List<User> getListUser();
    public boolean register(User u);
    boolean deleteUser(int id);
    User getUserById(int id);
    int countUser();
    public boolean saveUser(User u);
    public User findUserByUserName(String user);
}
