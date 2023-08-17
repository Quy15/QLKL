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
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author WIN10
 */
@RestController
@PropertySource("classpath:config.properties")
public class UserApi {
    @Autowired
    private UserService user;
     @Autowired
    private Environment env;
    
    @GetMapping("/api/usermanager/")
    public ResponseEntity<List<User>> getListUser(Model model, @RequestParam Map<String, String> params){
        List<User> user = this.user.getUser(params);
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        int count = this.user.countUser();
        model.addAttribute("count", Math.ceil(count * 1.0 / pageSize));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @DeleteMapping("/usermanager/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable("id") int id){
        this.user.deleteUser(id);
    }
}
