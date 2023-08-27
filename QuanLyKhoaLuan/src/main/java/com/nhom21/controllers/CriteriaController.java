/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.Criteria;
import com.nhom21.pojo.CriteriaHasThesisScore;
import com.nhom21.pojo.Thesis;
import com.nhom21.pojo.ThesisScore;
import com.nhom21.service.CriteriaHasThesisScoreService;
import com.nhom21.service.CriteriaService;
import com.nhom21.service.ThesisScoreService;
import com.nhom21.service.ThesisService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/setcriteria")
    public String setCriteria() {
        return "setcriteria";
    }

    @PostMapping("/setcriteria")
    public String saveCriteria(Model model, @RequestParam("thesisId") String thesisId, @RequestParam("criteriaId") String[] criteriaId, @RequestParam("thesisScoreId") String[] thesisScoreId) {
        Thesis thesis = this.theser.getThesisById(Integer.parseInt(thesisId));
        ArrayList<Criteria> cri = new ArrayList<>();
        for (int i = 0; i < criteriaId.length; i++) {
            cri.add(this.criser.getById(Integer.parseInt(criteriaId[i])));
        }
        
        int id = 0;
        ArrayList<ThesisScore> thes = new ArrayList<>();
        for (int i =0;i < thesisScoreId.length;i ++){
            thes.add(this.tsser.findThesisScoreById(Integer.parseInt(thesisScoreId[i])));
            if (thes.get(i).getThesisId().getId() == thesis.getId())
                id = Integer.parseInt(thesisScoreId[i]);
        }

        ThesisScore ts = this.tsser.findThesisScoreById(id);

        ArrayList<CriteriaHasThesisScore> cs = new ArrayList<>();
        for (int i = 0; i < criteriaId.length; i++) {
                cs.add(new CriteriaHasThesisScore(null, cri.get(i), ts));
        }

        if (this.csser.saveCriScore(cs)) {
            return "redirect:/index";
        }
        return "setcriteria";
    }
}
