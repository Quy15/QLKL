/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.pojo;

import java.util.List;

/**
 *
 * @author Admin
 */
public class ThesisScoreDetails {
    private Thesis thesis;
    private List<CriteriaHasThesisScore> criteriaScores;
    /**
     * @return the thesis
     */
    public Thesis getThesis() {
        return thesis;
    }

    /**
     * @param thesis the thesis to set
     */
    public void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }

    /**
     * @return the criteriaScores
     */
    public List<CriteriaHasThesisScore> getCriteriaScores() {
        return criteriaScores;
    }

    /**
     * @param criteriaScores the criteriaScores to set
     */
    public void setCriteriaScores(List<CriteriaHasThesisScore> criteriaScores) {
        this.criteriaScores = criteriaScores;
    }

}
