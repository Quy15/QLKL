/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WIN10
 */
@Entity
@Table(name = "thesis_score")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThesisScore.findAll", query = "SELECT t FROM ThesisScore t"),
    @NamedQuery(name = "ThesisScore.findById", query = "SELECT t FROM ThesisScore t WHERE t.thesisScorePK.id = :id"),
    @NamedQuery(name = "ThesisScore.findByName", query = "SELECT t FROM ThesisScore t WHERE t.name = :name"),
    @NamedQuery(name = "ThesisScore.findByEvaluationId", query = "SELECT t FROM ThesisScore t WHERE t.evaluationId = :evaluationId"),
    @NamedQuery(name = "ThesisScore.findByCriteriaId", query = "SELECT t FROM ThesisScore t WHERE t.criteriaId = :criteriaId"),
    @NamedQuery(name = "ThesisScore.findByScore", query = "SELECT t FROM ThesisScore t WHERE t.score = :score"),
    @NamedQuery(name = "ThesisScore.findByThesisEvaluationId", query = "SELECT t FROM ThesisScore t WHERE t.thesisScorePK.thesisEvaluationId = :thesisEvaluationId")})
public class ThesisScore implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ThesisScorePK thesisScorePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evaluation_id")
    private int evaluationId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "criteria_id")
    private int criteriaId;
    @Size(max = 45)
    @Column(name = "score")
    private String score;
    @JoinColumn(name = "thesis_evaluation_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ThesisEvaluation thesisEvaluation;

    public ThesisScore() {
    }

    public ThesisScore(ThesisScorePK thesisScorePK) {
        this.thesisScorePK = thesisScorePK;
    }

    public ThesisScore(ThesisScorePK thesisScorePK, String name, int evaluationId, int criteriaId) {
        this.thesisScorePK = thesisScorePK;
        this.name = name;
        this.evaluationId = evaluationId;
        this.criteriaId = criteriaId;
    }

    public ThesisScore(int id, int thesisEvaluationId) {
        this.thesisScorePK = new ThesisScorePK(id, thesisEvaluationId);
    }

    public ThesisScorePK getThesisScorePK() {
        return thesisScorePK;
    }

    public void setThesisScorePK(ThesisScorePK thesisScorePK) {
        this.thesisScorePK = thesisScorePK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(int evaluationId) {
        this.evaluationId = evaluationId;
    }

    public int getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(int criteriaId) {
        this.criteriaId = criteriaId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public ThesisEvaluation getThesisEvaluation() {
        return thesisEvaluation;
    }

    public void setThesisEvaluation(ThesisEvaluation thesisEvaluation) {
        this.thesisEvaluation = thesisEvaluation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (thesisScorePK != null ? thesisScorePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThesisScore)) {
            return false;
        }
        ThesisScore other = (ThesisScore) object;
        if ((this.thesisScorePK == null && other.thesisScorePK != null) || (this.thesisScorePK != null && !this.thesisScorePK.equals(other.thesisScorePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom21.pojo.ThesisScore[ thesisScorePK=" + thesisScorePK + " ]";
    }
    
}
