/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.service.StatsService;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author WIN10
 */
@Controller
public class StatController {

    @Autowired
    private StatsService stats;

    @GetMapping("/stat")
    private String getStat(Model model,@RequestParam Map<String,String> params) {
       model.addAttribute("stats", this.stats.countThesis());
       model.addAttribute("scorestats", this.stats.statsScore(params));
        return "stat";
    }
}
