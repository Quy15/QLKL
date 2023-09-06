/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service.impl;

import com.nhom21.pojo.ThesisScore;
import com.nhom21.repository.ThesisScoreRepository;
import com.nhom21.service.ThesisScoreService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WIN10
 */
@Service
public class ThesisScoreServiceImpl implements ThesisScoreService {

    @Autowired
    private ThesisScoreRepository tsrepo;

    @Override
    public boolean addOrUpdateThesisScore(ThesisScore ts) {
        return this.tsrepo.addOrUpdateThesisScore(ts);
    }

    @Override
    public boolean addOrUpdateThesisScore(ArrayList<ThesisScore> ts) {
        return this.tsrepo.addOrUpdateThesisScore(ts);
    }

    @Override
    public List<ThesisScore> getThesisScore() {
        return this.tsrepo.getThesisScore();
    }

    @Override
    public List<ThesisScore> getThesisScoreByUserDefenseId(int UserDefenseId) {
        return this.tsrepo.getThesisScoreByUserDefenseId(UserDefenseId);
    }

    public ThesisScore findThesisScoreById(int id) {
        return this.tsrepo.findThesisScoreById(id);
    }

    @Override

    public ThesisScore findThesisScoreByDefenseId(int id) {
        return this.tsrepo.findThesisScoreByDefenseId(id);
    }
    

    public Double getAverageScoreByThesisId(int thesisId) {
        return this.tsrepo.getAverageScoreByThesisId(thesisId);
    }

    @Override
    public List<Integer> getUserDenfenseIDByThesisIdInThesisScore(int ThesisId) {
        return this.tsrepo.getUserDenfenseIDByThesisIdInThesisScore(ThesisId);
    }

    @Override
    public Double getAverageScoreByThesisIdAndUserDefenseId(int thesisId, int userDefenseId) {
        return this.tsrepo.getAverageScoreByThesisIdAndUserDefenseId(thesisId, userDefenseId);
    }


}
