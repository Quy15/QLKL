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
    User getUserByUserName(String username);
    public boolean register(User u);
    int countUser();
}
