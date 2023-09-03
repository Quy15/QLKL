/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.InstructorThesis;
import com.nhom21.pojo.Thesis;
import com.nhom21.pojo.User;
import com.nhom21.service.ThesisInstructorService;
import java.text.ParseException;
import java.util.Map;
import javax.validation.Valid;

import com.nhom21.service.ThesisService;
import com.nhom21.service.UserService;
import java.util.ArrayList;
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
public class InstructorThesisController {

    @Autowired
    private ThesisInstructorService thesisI;

    @Autowired
    private ThesisService thesisService;
    @Autowired
    private UserService user;

    @GetMapping("/instructorThesis")
    public String listI(Model model, Map<String, String> params) {
        model.addAttribute("instructorThesis", new InstructorThesis());
        model.addAttribute("t", this.thesisService.getThesis(params));
        return "instructorThesis";
    }

    @PostMapping("/instructorThesis")
    public String addThesisI(@RequestParam("gvId") String[] gvId, @RequestParam("thesisid2") String thesisId) {
        ArrayList<User> user = new ArrayList<>();
        for (int i = 0; i < gvId.length; i++) {
            user.add(this.user.getUserById(Integer.parseInt(gvId[i])));
        }

        Thesis t = this.thesisService.getThesisById(Integer.parseInt(thesisId));

        InstructorThesis ti = new InstructorThesis(null, t, user.get(0));
        InstructorThesis ti2 = new InstructorThesis(null, t, user.get(1));

        if (this.thesisI.addOrUpdateThesisInstructor(ti) && this.thesisI.addOrUpdateThesisInstructor(ti2)) {
            return "redirect:/";
        }
        return "instructorThesis";
    }

    @GetMapping("/addThesisI/{id}")
    public String updateThesisI(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("thesisI", this.thesisI.getIDI(id));
        return "addThesisI";
    }
}
