/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author WIN10
 */
@Controller
@PropertySource("classpath:config.properties")
public class UserController {
    @Autowired
    private UserService user;
    @Autowired
    private Environment env;
    
    @GetMapping("/usermanager")
    @Transactional
    public String userManager(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("user", this.user.getUser(params));
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        int count = this.user.countUser();
        model.addAttribute("count", Math.ceil(count * 1.0 / pageSize));
        return "usermanager";
    }
}
