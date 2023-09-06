/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom21.service;

import com.nhom21.pojo.ThesisScore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WIN10
 */
public interface ThesisScoreService {
    public boolean addOrUpdateThesisScore(ThesisScore ts);
    boolean addOrUpdateThesisScore(ArrayList<ThesisScore> ts);
    public List<ThesisScore> getThesisScore();
    public List<ThesisScore> getThesisScoreByUserDefenseId(int UserDefenseId);
    public List<Integer> getUserDenfenseIDByThesisIdInThesisScore(int ThesisId);
    public Double getAverageScoreByThesisIdAndUserDefenseId(int thesisId, int userDefenseId);
    public ThesisScore findThesisScoreById(int id);
    public ThesisScore findThesisScoreByDefenseId(int id);
    public Double getAverageScoreByThesisId(int thesisId);

}
