/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service.impl;

import com.nhom21.pojo.CriteriaHasThesisScore;
import com.nhom21.repository.CriteriaHasThesisScoreRepository;

import com.nhom21.repository.ThesisScoreRepository;
import com.nhom21.service.CriteriaHasThesisScoreService;
import com.nhom21.service.CriteriaHasThesisScoreService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *

 * @author WIN10

 */
@Service
public class CriteriaHasThesisScoreServiceImpl implements CriteriaHasThesisScoreService{
    @Autowired
    private CriteriaHasThesisScoreRepository csrepo;
    @Override
    public List<CriteriaHasThesisScore> getCriteriaHasThesisScore() {
        return this.csrepo.getListCriteriaHasThesisScore();
    }

    @Override
    public List<CriteriaHasThesisScore> getListCriteriaHasThesisScoreByThesisScoreId(int ThesisScoreId) {
        return this.csrepo.getListCriteriaHasThesisScoreByThesisScoreId(ThesisScoreId);
    }
    
    @Override
    public boolean saveCriScore(ArrayList<CriteriaHasThesisScore> cs) {
        return this.csrepo.saveCriScore(cs);
    }

    @Override
    public List<CriteriaHasThesisScore> getCriScore() {
        return this.csrepo.getCriScore();
    }
    
}
