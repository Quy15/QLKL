/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license

 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template

 */
package com.nhom21.service;

import com.nhom21.pojo.CriteriaHasThesisScore;

import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author WIN10
 */
public interface CriteriaHasThesisScoreService {
    public boolean saveCriScore(ArrayList<CriteriaHasThesisScore> cs);
    public List<CriteriaHasThesisScore> getCriScore();
    public List<CriteriaHasThesisScore> getCriteriaHasThesisScore();
    public List<CriteriaHasThesisScore> getListCriteriaHasThesisScoreByThesisScoreId(int ThesisScoreId);

}
