/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service;

import com.nhom21.pojo.CriteriaHasThesisScore;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CriteriaHasThesisScoreService {
    public List<CriteriaHasThesisScore> getCriteriaHasThesisScore();
    public List<CriteriaHasThesisScore> getListCriteriaHasThesisScoreByThesisScoreId(int ThesisScoreId);
}
