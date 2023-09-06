/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.cloudinary.Cloudinary;
import com.nhom21.pojo.DefenseCommittee;
import com.nhom21.pojo.InstructorThesis;
import com.nhom21.pojo.Thesis;
import com.nhom21.pojo.ThesisParticipant;
import com.nhom21.pojo.User;
import com.nhom21.pojo.UserDefenseCommittee;
import com.nhom21.service.ThesisInstructorService;
import com.nhom21.service.ThesisParticipantsService;
import com.nhom21.service.ThesisService;
import com.nhom21.service.UserService;
import java.text.ParseException;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author WIN10
 */
@Controller
@PropertySource("classpath:config.properties")
public class ThesisController {
    
    @Autowired
    private Environment env;
    
    @Autowired
    private ThesisService thesis;

    @Autowired
    private UserService user;

    @Autowired
    private ThesisParticipantsService thesisP;

    @Autowired
    private ThesisInstructorService thesisI;
    
    @GetMapping("/thesisManager")
    @Transactional
    public String list (Model model, Map<String,String> params)
    {
        model.addAttribute("thesis", this.thesis.getThesis(params));
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        int count = this.thesis.countThesis();
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        return "thesisManager";
    }
    
    @GetMapping("/addThesis")
    @Transactional
    public String list(Model model) {
        model.addAttribute("thesiss", new Thesis());
        return "addThesis";
    }

    @PostMapping("/addThesis")
    public String addThesis(Model model, @ModelAttribute(value = "thesiss") @Valid Thesis t, BindingResult rs) throws ParseException {
        if (!rs.hasErrors()) {
            if (this.thesis.addOrUpdateThesis(t) == true) {
                return "redirect:/thesisParticipant";
            }
        }
        return "addThesis";
    }
    
    @GetMapping("/editthesis")
    public String edit(Model model){
        model.addAttribute("the", new Thesis());
        return "editthesis";
    }
    
    @PostMapping("/editthesis")
    public String editThe(@ModelAttribute(value = "the")@Valid Thesis t, BindingResult rs)throws ParseException{
        if (!rs.hasErrors()) {
            if (this.thesis.addOrUpdateThesis(t) == true) {
                return "redirect:/thesisManager";
            }
        }
        return "editthesis";
    }
    
    @GetMapping("/editthesis/{id}")
    public String updateThesis(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("the", this.thesis.getThesisById(id));
        
        return "editthesis";
    }

    
}
