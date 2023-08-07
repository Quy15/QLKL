/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.cloudinary.Cloudinary;
import com.nhom21.pojo.Thesis;
import com.nhom21.service.ThesisService;
import java.text.ParseException;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ThesisController {
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Autowired
    private Environment env;
    
    @Autowired
    private ThesisService thesis;
 
    
    @GetMapping("/thesisManager")
    @Transactional
    public String list(Model model){
        model.addAttribute("thesis", new Thesis());
        return "thesisManager";
    }
    
    @PostMapping("/thesisManager")
    public String addThesis(@ModelAttribute(value="thesis")@Valid Thesis t, BindingResult rs) throws ParseException{
        if(!rs.hasErrors()){
            if (this.thesis.addOrUpdateThesis(t) == true)
                return "redirect:/";
        }
        return "thesisManager";
    }
    
    @GetMapping("/thesisManager/{id}")
    public String updateThesis(Model model, @PathVariable(value = "id") int id){
        model.addAttribute("thesis", this.thesis.getThesisById(id));
        return  "thesisManager";
    }
    
    
}
