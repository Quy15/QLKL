/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.Criteria;
import com.nhom21.pojo.CriteriaHasThesisScore;
import com.nhom21.pojo.Thesis;
import com.nhom21.pojo.ThesisScore;
import com.nhom21.pojo.UserDefenseCommittee;
import com.nhom21.service.CriteriaHasThesisScoreService;
import com.nhom21.service.CriteriaService;
import com.nhom21.service.DefenseCommitteeService;
import com.nhom21.service.ThesisScoreService;
import com.nhom21.service.ThesisService;
import com.nhom21.service.UserDefenseCommitteeService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author WIN10
 */
@Controller
public class CriteriaController {

    @Autowired
    private ThesisService theser;
    @Autowired
    private ThesisScoreService tsser;
    @Autowired
    private CriteriaService criser;
    @Autowired
    private CriteriaHasThesisScoreService csser;
    @Autowired
    private DefenseCommitteeService defense;
    @Autowired
    private UserDefenseCommitteeService udser;

    @GetMapping("/setcriteria")
    public String setCriteria() {
        return "setcriteria";
    }

    @PostMapping("/setcriteria/{id}")
    public String saveCriteria(Model model, @RequestParam("thesisId") String thesisId,
            @RequestParam("criteriaId") String[] criteriaId,
            @RequestParam("thesisScoreId") String[] thesisScoreId,
            @RequestParam("userId") String userId,
            @RequestParam("defenseId") String defense) {
        Thesis thesis = this.theser.getThesisById(Integer.parseInt(thesisId));
//        Criteria cri = this.criser.getById(Integer.parseInt(criteriaId));
        ArrayList<Criteria> cri = new ArrayList<>();
        for (int i = 0; i < criteriaId.length; i++) {
            cri.add(this.criser.getById(Integer.parseInt(criteriaId[i])));
        }

        ArrayList<ThesisScore> thes = new ArrayList<>();
        ArrayList<CriteriaHasThesisScore> cris = new ArrayList<>();
        UserDefenseCommittee ud = this.udser.findByDefenseId(Integer.parseInt(userId));
        for (int i = 0; i < thesisScoreId.length; i++) {
            thes.add(this.tsser.findThesisScoreById(Integer.parseInt(thesisScoreId[i])));
            cris.add(new CriteriaHasThesisScore(null, cri.get(i), thes.get(i)));
        }

        if (this.csser.saveCriScore(cris)) {
            return "redirect:/dclist";
        }
        return "setcriteria";
    }

    @GetMapping("/setcriteria/{id}")
    public String getCri(Model model, @PathVariable("id") int id) {
        model.addAttribute("dfe", this.defense.getById(id));
        return "setcriteria";
    }
}
