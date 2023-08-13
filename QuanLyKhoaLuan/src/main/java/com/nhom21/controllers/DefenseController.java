/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.DefenseCommittee;
import com.nhom21.service.DefenseCommitteeService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author WIN10
 */
@Controller
public class DefenseController {
    @Autowired
    private DefenseCommitteeService defense;
    
    @GetMapping("/thesisdefense")
    public String defenseComm(Model model){
        model.addAttribute("defenseCommittee", new DefenseCommittee());
        return "thesisdefense";
    }
    
    @PostMapping("/thesisdefense")
    public String defenseCommAdd(@ModelAttribute(value = "defenseCommittee")@Valid DefenseCommittee d, BindingResult rs){
        if(!rs.hasErrors()){
            if(this.defense.addDefense(d) == true)
                return "defenseuser";
        }
        return "thesisdefense";
    }
}
