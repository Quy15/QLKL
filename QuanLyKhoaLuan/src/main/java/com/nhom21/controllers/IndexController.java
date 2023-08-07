/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.service.ThesisParticipantsService;
import com.nhom21.service.ThesisService;
import com.nhom21.service.UserService;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author WIN10
 */
@Controller
public class IndexController {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private Environment env;

    @Autowired
    private ThesisService thesis;

    @Autowired
    private UserService user;
    
    @Autowired
    private ThesisParticipantsService thesisP;

    @RequestMapping("/")
    @Transactional
    public String index(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("thesis", this.thesis.getThesis(params));
        model.addAttribute("user", this.user.getUser());
        model.addAttribute("thesisP", this.thesisP.getParti());
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        int count = this.thesis.countThesis();
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        return "index";
    }
}
