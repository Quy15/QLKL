/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.Thesis;
import com.nhom21.pojo.ThesisParticipant;
import com.nhom21.pojo.User;
import com.nhom21.service.ThesisParticipantsService;
import com.nhom21.service.ThesisService;
import com.nhom21.service.UserService;
import java.text.ParseException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;

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
    @Autowired
    private UserService user;

    @GetMapping("/thesisParticipant")
    public String listP(Model model, Map<String, String> params) {
        model.addAttribute("the", this.thesis.getThesis(params));
        return "thesisParticipant";
    }

    @PostMapping("/thesisParticipant")
    public String addThesisP(@RequestParam("svId")String[] svId, @RequestParam("thesisid")String thesisId) {
        ArrayList<User> u = new ArrayList<>();
        for (int i=0;i < svId.length;i ++){
            u.add(this.user.getUserById(Integer.parseInt(svId[i])));
        }
        
        Thesis thesis = this.thesis.getThesisById(Integer.parseInt(thesisId));
        
        ThesisParticipant tp1 = new ThesisParticipant(null, thesis, u.get(0));
        ThesisParticipant tp2 = new ThesisParticipant(null, thesis, u.get(1));
        if (this.thesisP.addOrUpdateThesisParticipants(tp1) == true && this.thesisP.addOrUpdateThesisParticipants(tp1) == true) {
            return "redirect:/instructorThesis";
        }
        return "thesisParticipant";
    }

    @GetMapping("/addThesisP/{id}")
    public String updateThesisP(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("thesisP", this.thesisP.getIDP(id));
        return "addThesisP";
    }
}
