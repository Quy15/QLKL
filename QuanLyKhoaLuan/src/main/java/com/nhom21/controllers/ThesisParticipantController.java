/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.ThesisParticipant;
import com.nhom21.service.ThesisParticipantsService;
import com.nhom21.service.ThesisService;
import java.text.ParseException;
import java.util.Map;
import javax.validation.Valid;
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
public class ThesisParticipantController {
    @Autowired
    private ThesisParticipantsService thesisP;
    @Autowired
    private ThesisService thesis;
    
    @GetMapping("/thesisParticipant")
    public String listP(Model model, Map<String,String> params) {
        model.addAttribute("thesisP", new ThesisParticipant());
        model.addAttribute("the", this.thesis.getThesis(params));
        return "thesisParticipant";
    }

    @PostMapping("/thesisParticipant")
    public String addThesisP(@ModelAttribute(value = "thesisP")@Valid ThesisParticipant tp, BindingResult rs) throws ParseException {
        if (!rs.hasErrors()) {
            if (this.thesisP.addOrUpdateThesisParticipants(tp) == true) {
                return "redirect:/instructorThesis";
            }
        }
        return "thesisParticipant";
    }
    
     @GetMapping("/addThesisP/{id}")
    public String updateThesisP(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("thesisP", this.thesisP.getIDP(id));
        return "addThesisP";
    }
}
