/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.InstructorThesis;
import com.nhom21.service.ThesisInstructorService;
import java.text.ParseException;
import java.util.Map;
import javax.validation.Valid;

import com.nhom21.service.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author WIN10
 */
@Controller
public class InstructorThesisController {
    @Autowired
    private ThesisInstructorService thesisI;

    @Autowired
    private ThesisService thesisService;
    
    @GetMapping("/instructorThesis")
    public String listI(Model model, Map<String,String> params) {
        model.addAttribute("instructorThesis", new InstructorThesis());
        model.addAttribute("t", this.thesisService.getThesis(params));
        return "instructorThesis";
    }

    @PostMapping("/instructorThesis")
    public String addThesisI(@ModelAttribute(value = "instructorThesis")@Valid InstructorThesis ti, BindingResult rs) throws ParseException {
        if (!rs.hasErrors()) {
            if (this.thesisI.addOrUpdateThesisInstructor(ti)) {
                return "redirect:/";
            }
        }
        return "instructorThesis";
    }
    
    @GetMapping("/addThesisI/{id}")
    public String updateThesisI(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("thesisI", this.thesisI.getIDI(id));
        return "addThesisI";
    }
}
