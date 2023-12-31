/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom21.repository;

import com.nhom21.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author WIN10
 */
public interface UserRepository {
    List<User> getUser(Map<String, String> params);
    List<User> getListUser();
    boolean saveUser(User u);
    User getUserByUserName(String username);
    User getUserById(int id);
    User findUserByUserName(String user);
    public boolean register(User u);
    int countUser();
    boolean deleteUser(int id);
    User getUserByUsername(String username);
    boolean authUser(String username, String password);
}
