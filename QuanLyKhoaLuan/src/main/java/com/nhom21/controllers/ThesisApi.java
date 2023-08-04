/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.Thesis;
import com.nhom21.service.ThesisService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    
    @GetMapping("/api/{id}")
    public ResponseEntity<Thesis> getThesisById(@PathVariable("id") int id){
        Thesis t = this.thesisSer.getThesisById(id);
        if (t == null)
            return new ResponseEntity<>(t, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }
    
    @PostMapping("/api")
    public ResponseEntity<Void> addThesis(String date, @ModelAttribute(value="thesis")@Valid Thesis t, BindingResult rs){
        boolean add = this.thesisSer.addOrUpdateThesis(t, date);
        if(!rs.hasErrors()){
            if (add == true)
                return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    
    @DeleteMapping("/api/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable("id") int id){
        this.thesisSer.deleteThesis(id);
    }
}
