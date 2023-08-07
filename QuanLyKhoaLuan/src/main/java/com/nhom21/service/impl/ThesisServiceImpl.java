/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service.impl;

import com.nhom21.pojo.Thesis;
import com.nhom21.repository.ThesisRepository;
import com.nhom21.service.ThesisService;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author WIN10
 */
@Service
public class ThesisServiceImpl implements ThesisService{
    
    @Autowired
    private ThesisRepository thesisRepository;
    
    @Override
    public List<Thesis> getThesis(Map<String, String> params) {
        return this.thesisRepository.getThesis(params);
    }

    @Override
    public int countThesis() {
        return this.thesisRepository.countThesis();
    }

    @Override
    public boolean addOrUpdateThesis(Thesis s) {
        return this.thesisRepository.addOrUpdateThesis(s);
    }

    @Override
    public Thesis getThesisById(int id) {
        return this.thesisRepository.getThesisById(id);
    }

    @Override
    public boolean deleteThesis(int id) {
        return this.thesisRepository.deleteThesis(id);
    }

    
    
}
