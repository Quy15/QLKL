/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.User;
import com.nhom21.service.UserService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author WIN10
 */
@RestController
@RequestMapping("/api")
public class UserApi {
    @Autowired
    private UserService user;
    
    @DeleteMapping("/usermanager/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable("id") int id){
        this.user.deleteUser(id);
    }
    
    @GetMapping("/users/")
    @CrossOrigin
    public ResponseEntity<List<User>> list(@RequestParam Map<String, String> params){
        return new ResponseEntity<>(this.user.getUser(params), HttpStatus.OK);
    }
}
