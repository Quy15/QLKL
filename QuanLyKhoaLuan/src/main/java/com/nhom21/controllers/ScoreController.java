/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.User;
import com.nhom21.service.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author WIN10
 */
@Controller
public class ScoreController {
    @Autowired
    private UserService user;
    
    @GetMapping("/score")
    public String getScore(Model model, Principal p){
        String username = p.getName();
        User u = this.user.findUserByUserName(username);
        model.addAttribute("userid", u.getId());
        return "score";
    }
}
