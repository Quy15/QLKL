/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license

 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template

 */
package com.nhom21.repository;

import com.nhom21.pojo.CriteriaHasThesisScore;

import java.util.ArrayList;

import java.util.List;

public interface CriteriaHasThesisScoreRepository {
    List<CriteriaHasThesisScore> getListCriteriaHasThesisScore();
    List<CriteriaHasThesisScore> getListCriteriaHasThesisScoreByThesisScoreId(int ThesisScoreId);
    boolean saveCriScore(ArrayList<CriteriaHasThesisScore> cs);
    List<CriteriaHasThesisScore> getCriScore();
}
