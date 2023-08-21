/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.User;
import com.nhom21.service.UserService;
import java.security.Principal;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author WIN10
 */
@Controller
//@PropertySource("classpath:config.properties")
public class UserController {
    @Autowired
    private UserService userDetailService;
    @Autowired
    private Environment env;
    @Autowired
    private BCryptPasswordEncoder passencoder;
    
    @GetMapping("/usermanager")
    @Transactional
    public String userManager(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("user", this.userDetailService.getUser(params));
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        int count = this.userDetailService.countUser();
        model.addAttribute("count", Math.ceil(count * 1.0 / pageSize));
        return "usermanager";
    }
    
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
    
    @GetMapping("/infouser")
    public String userInfor(Model model, Principal principal) {
        model.addAttribute("name", principal.getName());
        model.addAttribute("userinfor", this.user.getListUser());
        return "infouser";
    }
    
    @GetMapping("/changepassword")
    public String loadChange(){
        return "changepassword";
    }
    
    @PostMapping("/changepassword")
    public String changePassword(Principal p, @RequestParam("oldpassword") String oldPassword, @RequestParam("newpassword")String newPassword, HttpSession s){
        String username = p.getName();
        User u = this.user.findUserByUserName(username);
        
        boolean f = passencoder.matches(oldPassword, u.getPassword());
        
        if (f){
            u.setPassword(this.passencoder.encode(newPassword));
            this.user.saveUser(u);
            s.setAttribute("message", "Thay đổi mật khẩu thành công");
            return "redirect:/infouser";
        }else{
            s.setAttribute("message", "Vui lòng nhập đúng mật khẩu cũ");
            return "redirect:/changepassword";
        }
    }
}
