/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.Thesis;
import com.nhom21.service.ThesisService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author WIN10
 */
@RestController
public class ThesisApi {
    @Autowired
    private ThesisService thesisSer;
    
    @Autowired
    private Environment env;
    
    
    @GetMapping("/api")
    public ResponseEntity<List<Thesis>> getThesis(@RequestParam Map<String,String> params){
        List<Thesis> thesiss = this.thesisSer.getThesis(params);
        return new ResponseEntity<>(thesiss, HttpStatus.OK);
    }
}
