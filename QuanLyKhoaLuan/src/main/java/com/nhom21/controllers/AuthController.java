/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.User;
import com.nhom21.service.AuthService;
import com.nhom21.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author WIN10
 */
@Controller
public class AuthController {
    @Autowired
    private UserService user;
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    @PostMapping("/register")
    public String register(@ModelAttribute(value = "user") User u , BindingResult rs){
        if(!rs.hasErrors()){
            if (this.user.register(u) == true)
                return "redirect:/login";
        }
        return "register";
    }
}
