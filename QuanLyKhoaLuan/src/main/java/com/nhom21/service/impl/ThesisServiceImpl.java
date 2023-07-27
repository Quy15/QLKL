/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service.impl;

import com.nhom21.pojo.Thesis;
import com.nhom21.repository.ThesisRepository;
import com.nhom21.service.ThesisService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author WIN10
 */
public class ThesisServiceImpl implements ThesisService{
    
    @Autowired
    private ThesisRepository thesisRepository;

    @Override
    public List<Thesis> getThesis(Map<String, String> params) {
        return this.thesisRepository.getThesis(params);
    }

    @Override
    public int countThesis() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addOrUpdateThesis(Thesis s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
