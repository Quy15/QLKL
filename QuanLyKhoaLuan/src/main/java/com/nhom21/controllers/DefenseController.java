/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.DefenseCommittee;
import com.nhom21.pojo.Thesis;
import com.nhom21.pojo.ThesisScore;
import com.nhom21.pojo.User;
import com.nhom21.pojo.UserDefenseCommittee;
import com.nhom21.service.DefenseCommitteeService;
import com.nhom21.service.EmailService;
import com.nhom21.service.ThesisScoreService;
import com.nhom21.service.ThesisService;
import com.nhom21.service.UserDefenseCommitteeService;
import com.nhom21.service.UserService;
import java.util.ArrayList;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
@PropertySource("classpath:config.properties")
public class DefenseController {

    @Autowired
    private DefenseCommitteeService defense;
    @Autowired
    private UserDefenseCommitteeService udefense;
    @Autowired
    private ThesisScoreService theser;
    @Autowired
    private ThesisService tser;
    @Autowired
    private Environment env;
    @Autowired
    private EmailService email;
    @Autowired
    private UserService user;

    @GetMapping("/dclist")
    public String defenseList(Model model) {
        model.addAttribute("defenselist", this.defense.getList());
        model.addAttribute("udefense", this.udefense.getList());
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        int count = this.defense.countDefense();
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        model.addAttribute("defenseCommittee", new DefenseCommittee());
       
        return "dclist";
    }

    @GetMapping("/sendmail")
    public String send() {
        return "sendmail";
    }

    @PostMapping("/sendmail")
    public String sendMail(@RequestParam("userId") String[] userid) {
        ArrayList<User> u = new ArrayList<>();
        for (int i = 0; i < userid.length; i++) {
            u.add(this.user.getUserById(Integer.parseInt(userid[i])));
        }
        u.forEach(obj -> {
            this.email.sendScore(obj.getLastName(), obj.getEmail());
        });
        return "redirect:/dclist";
    }

    @GetMapping("/lockdefense")
    public String lock(Model model, Map<String, String> params) {
        model.addAttribute("defense", this.defense.getList());
        model.addAttribute("thesis", this.tser.getThesis(params));
        return "lockdefense";
    }

    @PostMapping("/lockdefense/{id}")
    public String lockDefense(Model model, @RequestParam("defenseId") String id, @RequestParam("thesisid") String[] thesisId,
            @RequestParam("userdefenseid") String[] udc, @RequestParam("thesisscoreid") String[] tsid, @RequestParam("userId") String[] userid) {
        int defenseid = Integer.parseInt(id);
        DefenseCommittee dc = this.defense.getById(defenseid);
        ArrayList<UserDefenseCommittee> ud = new ArrayList<>();
        for (int i = 0; i < udc.length; i++) {
            ud.add(this.udefense.findByDefenseId(Integer.parseInt(udc[i])));
        }
        ArrayList<ThesisScore> ts = new ArrayList<>();
        for (int i = 0; i < tsid.length; i++) {
            ts.add(this.theser.findThesisScoreByDefenseId(Integer.parseInt(tsid[i])));
        }
        ArrayList<Thesis> thesis = new ArrayList<>();
        for (int i = 0; i < thesisId.length; i++) {
            thesis.add(this.tser.getThesisById(Integer.parseInt(thesisId[i])));
        }

        for (int i = 0; i < udc.length; i++) {
            if (ud.get(i).getDefenseCommitteeId().getId() == dc.getId()
                    && ud.get(i).getId() == ts.get(i).getUserDefenseCommitteeId().getId()
                    && ts.get(i).getThesisId().getId() == thesis.get(i).getId()
                    && ts.get(i).getScore() != null) {
                thesis.get(i).setStatus("Đã thực hiện");
            }
        }

        ArrayList<User> u = new ArrayList<>();
        for (int i = 0; i < userid.length; i++) {
            u.add(this.user.getUserById(Integer.parseInt(userid[i])));
        }
        
        if (this.tser.saveThesis(thesis) == true) {
            u.forEach(obj -> {
                this.email.sendScore(obj.getLastName(), obj.getEmail());
            });
            return "redirect:/dclist";
        }
        return "lockdefense";
    }

    @GetMapping("/lockdefense/{id}")
    public String updateDefense(Model model, @PathVariable("id") int id) {
        model.addAttribute("defense", this.defense.getById(id));
        return "lockdefense";
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
