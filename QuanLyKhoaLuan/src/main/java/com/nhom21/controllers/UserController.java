/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.User;
import com.nhom21.service.MajorService;
import com.nhom21.service.UserService;
import java.security.Principal;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

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
    
    @GetMapping("/inforuser")
    public String userInfor(Model model, Principal principal){
       model.addAttribute("name", principal.getName());
       model.addAttribute("userinfor", this.user.getListUser());

        return "inforuser";
    }
    
//    @PutMapping("/inforuser/{id}")
//    public String 
    
    @GetMapping("/addUser")
    public String register(Model model){
        model.addAttribute("user1", new User());
        return "addUser";
    }
    
    @PostMapping("/addUser")
    public String register(@ModelAttribute(value = "user1")@Valid User u , BindingResult rs){
        if(!rs.hasErrors()){
            if (this.user.register(u) == true)
                return "redirect:/usermanager";
        }
        return "addUser";
    }
    
    @GetMapping("/addUser/{id}")
    public String updateThesis(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("user1", this.user.getUserById(id));
        return "addUser";
    }
}
