/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.DefenseCommittee;
import com.nhom21.pojo.DefenseCommitteeRole;
import com.nhom21.pojo.Thesis;
import com.nhom21.pojo.ThesisScore;
import com.nhom21.pojo.User;
import com.nhom21.pojo.UserDefenseCommittee;
import com.nhom21.service.DefenseCommitteeRoleService;
import com.nhom21.service.DefenseCommitteeService;
import com.nhom21.service.EmailService;
import com.nhom21.service.ThesisScoreService;
import com.nhom21.service.ThesisService;
import com.nhom21.service.UserDefenseCommitteeService;
import com.nhom21.service.UserService;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class UserDefenseController {

    @Autowired
    private UserDefenseCommitteeService userD;
    @Autowired
    private DefenseCommitteeService defense;
    @Autowired
    private UserService user;
    @Autowired
    private DefenseCommitteeRoleService drole;
    @Autowired
    private ThesisScoreService tsser;
    @Autowired
    private ThesisService tser;
    @Autowired
    private EmailService emailService;

    @GetMapping("/defenseuser")
    public String addUD(Model model) {
        return "defenseuser";
    }

    @PostMapping("/defenseuser")
    public String addUD(
            @RequestParam("userId") String[] userId,
            @RequestParam("defenseCommitteeId") String dc, @RequestParam("defenseCommitteeRoleId") ArrayList<String> dr) {
        ArrayList<User> u = new ArrayList<>();
        for (int i = 0; i < userId.length; i++) {
            u.add(user.getUserById(Integer.parseInt(userId[i])));
        }
        DefenseCommittee defensec = defense.getById(Integer.parseInt(dc));

        ArrayList<DefenseCommitteeRole> derole = new ArrayList<>();
        for (int i = 0; i < dr.size(); i++) {
            derole.add(drole.getById(Integer.parseInt(dr.get(i))));
        }

        ArrayList<UserDefenseCommittee> ud = new ArrayList<>();
        for (int i = 0; i < userId.length; i++) {
            ud.add(new UserDefenseCommittee(null, defensec, derole.get(i), u.get(i)));
            emailService.sendMail(u.get(i).getLastName(), u.get(i).getEmail(), defensec.getName());
        }

        if (this.userD.addUserCommit(ud)) {
            return "redirect:/dclist";
        }
        return "defenseuser";
    }

    @GetMapping("/thesisscore")
    public String getThesisScore() {
        return "thesisscore";
    }

    @GetMapping("/thesisscore/{id}")
    public String getThesisScoreById(Model model, @PathVariable("id") int id) {
        model.addAttribute("def", this.defense.getById(id));
        return "thesisscore";
    }

    @PostMapping("/thesisscore/{id}")
    public String saveThesisScore(@RequestParam("userdefenseId") String userdefenseId,
            @RequestParam("thesisId")String thesisId) {
        UserDefenseCommittee ud = this.userD.findByDefenseId(Integer.parseInt(userdefenseId));
        Thesis t = this.tser.getThesisById(Integer.parseInt(thesisId));
        ThesisScore ts = new ThesisScore(null, null, null, t, ud);
       this.tsser.addOrUpdateThesisScore(ts);
       return "redirect:/dclist";
    }
}
