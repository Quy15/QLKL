/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.repository;

import com.nhom21.pojo.CriteriaHasThesisScore;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CriteriaHasThesisScoreRepository {
    List<CriteriaHasThesisScore> getListCriteriaHasThesisScore();
    List<CriteriaHasThesisScore> getListCriteriaHasThesisScoreByThesisScoreId(int ThesisScoreId);
}
