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
import com.nhom21.service.ThesisScoreService;
import com.nhom21.service.ThesisService;
import com.nhom21.service.UserDefenseCommitteeService;
import com.nhom21.service.UserService;
import java.util.ArrayList;
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
    @Autowired
    private ThesisScoreService tsser;
    @Autowired
    private ThesisService tser;
    
    @GetMapping("/defenseuser")
    public String addUD(Model model){
        return "defenseuser";
    }
    
//    @PostMapping("/defenseuser")
//    public String addUD(
//            @RequestParam("userId")String userId, @RequestParam("userId2")String userId2, @RequestParam("userId3")String userId3, @RequestParam("userId4")String userId4, @RequestParam("userId5")String userId5, 
//            @RequestParam("defenseCommitteeId") String dc, @RequestParam("defenseCommitteeRoleId")String dr, @RequestParam("defenseCommitteeRoleId2")String dr2, @RequestParam("defenseCommitteeRoleId3")String dr3,
//            @RequestParam("defenseCommitteeRoleId4")String dr4,@RequestParam("defenseCommitteeRoleId5")String dr5, @RequestParam("thesisId")String ts,@RequestParam("thesisId2")String ts2,@RequestParam("thesisId3")String ts3,@RequestParam("thesisId4")String ts4,@RequestParam("thesisId5")String ts5 ){
//        User u1 = user.getUserById(Integer.parseInt(userId));
//        User u2 = user.getUserById(Integer.parseInt(userId2));
//        User u3 = user.getUserById(Integer.parseInt(userId3));
//        User u4 = user.getUserById(Integer.parseInt(userId4));
//        User u5 = user.getUserById(Integer.parseInt(userId5));
//        DefenseCommittee defensec = defense.getById(Integer.parseInt(dc));
//        DefenseCommitteeRole derole = drole.getById(Integer.parseInt(dr));
//        DefenseCommitteeRole derole2 = drole.getById(Integer.parseInt(dr2));
//        DefenseCommitteeRole derole3 = drole.getById(Integer.parseInt(dr3));
//        DefenseCommitteeRole derole4 = drole.getById(Integer.parseInt(dr4));
//        DefenseCommitteeRole derole5 = drole.getById(Integer.parseInt(dr5));
//        Thesis t1 = tser.getThesisById(Integer.parseInt(ts));
//        Thesis t2 = tser.getThesisById(Integer.parseInt(ts2));
//        Thesis t3 = tser.getThesisById(Integer.parseInt(ts3));
//        Thesis t4 = tser.getThesisById(Integer.parseInt(ts4));
//        Thesis t5 = tser.getThesisById(Integer.parseInt(ts5));
//        
//        UserDefenseCommittee ud1 = new UserDefenseCommittee(null, defensec, derole, u1);
//        UserDefenseCommittee ud2 = new UserDefenseCommittee(null, defensec, derole2, u2);
//        UserDefenseCommittee ud3 = new UserDefenseCommittee(null, defensec, derole3, u3);
//        UserDefenseCommittee ud4 = new UserDefenseCommittee(null, defensec, derole4, u4);
//        UserDefenseCommittee ud5 = new UserDefenseCommittee(null, defensec, derole5, u5);
//        
//        ThesisScore thesisscore1 = new ThesisScore(null, null, null, t1,ud1);
//        ThesisScore thesisscore2 = new ThesisScore(null, null, null, t2,ud2);
//        ThesisScore thesisscore3 = new ThesisScore(null, null, null, t3,ud3);
//        ThesisScore thesisscore4 = new ThesisScore(null, null, null, t4,ud4);
//        ThesisScore thesisscore5 = new ThesisScore(null, null, null, t5,ud5);
//        if (this.userD.addUserCommit(ud1) && this.userD.addUserCommit(ud2)  && this.userD.addUserCommit(ud3) 
//                && this.userD.addUserCommit(ud4) && this.userD.addUserCommit(ud5) && this.tsser.addOrUpdateThesisScore(thesisscore1)
//                && this.tsser.addOrUpdateThesisScore(thesisscore2) && this.tsser.addOrUpdateThesisScore(thesisscore3) && this.tsser.addOrUpdateThesisScore(thesisscore4) && this.tsser.addOrUpdateThesisScore(thesisscore5))
//            return "redirect:/dclist";
//        return "defenseuser";
//    }
    
    @PostMapping("/defenseuser")
    public String addUD(
            @RequestParam("userId")String[] userId, 
            @RequestParam("defenseCommitteeId") String dc, @RequestParam("defenseCommitteeRoleId")ArrayList<String> dr, 
            @RequestParam("thesisId")String[] ts){
        ArrayList<User> u = new ArrayList<>();
        for(int i = 0; i < userId.length;i ++){
            u.add(user.getUserById(Integer.parseInt(userId[i])));
        }
        DefenseCommittee defensec = defense.getById(Integer.parseInt(dc));
        ArrayList<DefenseCommitteeRole> derole = new ArrayList<>();
        for(int i = 0; i < dr.size();i ++){
            derole.add(drole.getById(Integer.parseInt(dr.get(i))));
        }
        
        ArrayList<Thesis> thesis = new ArrayList<>();
        for(int i = 0; i < ts.length;i ++){
            thesis.add(tser.getThesisById(Integer.parseInt(ts[i])));
        }
        
        ArrayList<UserDefenseCommittee> ud = new ArrayList<>();
        for(int i = 0; i < userId.length;i ++){
            ud.add(new UserDefenseCommittee(null, defensec, derole.get(i), u.get(i)));
        }
        
        ArrayList<ThesisScore> thesisscore = new ArrayList<>();
        for(int i = 0; i < ts.length;i ++){
            thesisscore.add(new ThesisScore(null, null, null, thesis.get(i),ud.get(i)));
        }
        if (this.userD.addUserCommit(ud) && this.tsser.addOrUpdateThesisScore(thesisscore))
            return "redirect:/dclist";
        return "defenseuser";
    }
}
