/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service.impl;

import com.nhom21.pojo.CriteriaHasThesisScore;
import com.nhom21.repository.CriteriaHasThesisScoreRepository;
import com.nhom21.repository.ThesisScoreRepository;
import com.nhom21.service.CriteriaHasThesisScoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CriteriaHasThesisScoreServiceImpl implements CriteriaHasThesisScoreService{
    @Autowired
    private CriteriaHasThesisScoreRepository chtsrepo;
    @Override
    public List<CriteriaHasThesisScore> getCriteriaHasThesisScore() {
        return this.chtsrepo.getListCriteriaHasThesisScore();
    }

    @Override
    public List<CriteriaHasThesisScore> getListCriteriaHasThesisScoreByThesisScoreId(int ThesisScoreId) {
        return this.chtsrepo.getListCriteriaHasThesisScoreByThesisScoreId(ThesisScoreId);
    }
    
}
