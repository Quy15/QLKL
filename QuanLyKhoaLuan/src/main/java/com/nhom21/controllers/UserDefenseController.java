/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.DefenseCommittee;
import com.nhom21.pojo.DefenseCommitteeRole;
import com.nhom21.pojo.User;
import com.nhom21.pojo.UserDefenseCommittee;
import com.nhom21.service.DefenseCommitteeRoleService;
import com.nhom21.service.DefenseCommitteeService;
import com.nhom21.service.UserDefenseCommitteeService;
import com.nhom21.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    
    @GetMapping("/defenseuser")
    public String addUD(Model model){
        return "defenseuser";
    }
    
    @PostMapping("/defenseuser")
    public String addUD(
            @RequestParam("userId")String userId, @RequestParam("userId2")String userId2, @RequestParam("userId3")String userId3, @RequestParam("userId4")String userId4, @RequestParam("userId5")String userId5, 
            @RequestParam("defenseCommitteeId") String dc, @RequestParam("defenseCommitteeRoleId")String dr, @RequestParam("defenseCommitteeRoleId2")String dr2, @RequestParam("defenseCommitteeRoleId3")String dr3,@RequestParam("defenseCommitteeRoleId4")String dr4,@RequestParam("defenseCommitteeRoleId5")String dr5){
        User u1 = user.getUserById(Integer.parseInt(userId));
        User u2 = user.getUserById(Integer.parseInt(userId2));
        User u3 = user.getUserById(Integer.parseInt(userId3));
        User u4 = user.getUserById(Integer.parseInt(userId4));
        User u5 = user.getUserById(Integer.parseInt(userId5));
        DefenseCommittee defensec = defense.getById(Integer.parseInt(dc));
        DefenseCommitteeRole derole = drole.getById(Integer.parseInt(dr));
        DefenseCommitteeRole derole2 = drole.getById(Integer.parseInt(dr2));
        DefenseCommitteeRole derole3 = drole.getById(Integer.parseInt(dr3));
        DefenseCommitteeRole derole4 = drole.getById(Integer.parseInt(dr4));
        DefenseCommitteeRole derole5 = drole.getById(Integer.parseInt(dr5));
        
        UserDefenseCommittee ud1 = new UserDefenseCommittee(null, defensec, derole, u1);
        UserDefenseCommittee ud2 = new UserDefenseCommittee(null, defensec, derole2, u2);
        UserDefenseCommittee ud3 = new UserDefenseCommittee(null, defensec, derole3, u3);
        UserDefenseCommittee ud4 = new UserDefenseCommittee(null, defensec, derole4, u4);
        UserDefenseCommittee ud5 = new UserDefenseCommittee(null, defensec, derole5, u5);
        if (this.userD.addUserCommit(ud1) && this.userD.addUserCommit(ud2)  && this.userD.addUserCommit(ud3) && this.userD.addUserCommit(ud4) && this.userD.addUserCommit(ud5))
            return "redirect:/dclist";
        return "defenseuser";
    }
}
