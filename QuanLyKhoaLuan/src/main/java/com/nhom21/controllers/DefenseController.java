/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.DefenseCommittee;
import com.nhom21.service.DefenseCommitteeService;
import com.nhom21.service.UserDefenseCommitteeService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
@PropertySource("classpath:config.properties")
public class DefenseController {

    @Autowired
    private DefenseCommitteeService defense;
    @Autowired
    private UserDefenseCommitteeService udefense;
    @Autowired
    private Environment env;

    @GetMapping("/dclist")
    public String defenseList(Model model) {
        model.addAttribute("defenselist", this.defense.getList());
        model.addAttribute("udefense", this.udefense.getList());
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        int count = this.defense.countDefense();
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        return "dclist";
    }

    @GetMapping("/thesisdefense")
    public String defenseComm(Model model) {
        model.addAttribute("defenseCommittee", new DefenseCommittee());
        return "thesisdefense";
    }

    @PostMapping("/thesisdefense")
    public String defenseCommAdd(@ModelAttribute(value = "defenseCommittee") @Valid DefenseCommittee d, BindingResult rs) {
        if (!rs.hasErrors()) {
            if (this.defense.addDefense(d) == true) {
                return "redirect:/defenseuser";
            }
        }
        return "thesisdefense";
    }

}
