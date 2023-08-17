/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.UserDefenseCommittee;
import com.nhom21.service.DefenseCommitteeService;
import com.nhom21.service.UserDefenseCommitteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author WIN10
 */
@Controller
public class UserDefenseController {
    @Autowired
    private UserDefenseCommitteeService userD;
    @Autowired
    private DefenseCommitteeService defense;
    
    @GetMapping("/defenseuser")
    public String addUD(Model model){
        model.addAttribute("userdefensecommittee", new UserDefenseCommittee());
        return "defenseuser";
    }
    
    @PostMapping("/defenseuser")
    public String addUD(@ModelAttribute(value = "userdefensecommittee") UserDefenseCommittee ud){
        if (this.userD.addUserCommit(ud) == true)
            return "redirect:/dclist";
        return "defenseuser";
    }
}
