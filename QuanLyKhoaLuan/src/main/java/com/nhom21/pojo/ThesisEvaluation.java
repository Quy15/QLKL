/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author WIN10
 */
@Entity
@Table(name = "thesis_evaluation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThesisEvaluation.findAll", query = "SELECT t FROM ThesisEvaluation t"),
    @NamedQuery(name = "ThesisEvaluation.findById", query = "SELECT t FROM ThesisEvaluation t WHERE t.thesisEvaluationPK.id = :id"),
    @NamedQuery(name = "ThesisEvaluation.findByAverageScore", query = "SELECT t FROM ThesisEvaluation t WHERE t.averageScore = :averageScore"),
    @NamedQuery(name = "ThesisEvaluation.findByThesisId", query = "SELECT t FROM ThesisEvaluation t WHERE t.thesisId = :thesisId"),
    @NamedQuery(name = "ThesisEvaluation.findByCommitteeId", query = "SELECT t FROM ThesisEvaluation t WHERE t.committeeId = :committeeId"),
    @NamedQuery(name = "ThesisEvaluation.findByEvaluatorId", query = "SELECT t FROM ThesisEvaluation t WHERE t.evaluatorId = :evaluatorId"),
    @NamedQuery(name = "ThesisEvaluation.findByThesisId1", query = "SELECT t FROM ThesisEvaluation t WHERE t.thesisEvaluationPK.thesisId1 = :thesisId1")})
public class ThesisEvaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ThesisEvaluationPK thesisEvaluationPK;
    @Size(max = 45)
    @Column(name = "average_score")
    private String averageScore;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thesis_id")
    private int thesisId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "committee_id")
    private int committeeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evaluator_id")
    private int evaluatorId;
    @ManyToMany(mappedBy = "thesisEvaluationSet")
    private Set<Criteria> criteriaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thesisEvaluation")
    private Set<ThesisScore> thesisScoreSet;
    @JoinColumn(name = "thesis_id1", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Thesis thesis;

    public ThesisEvaluation() {
    }

    public ThesisEvaluation(ThesisEvaluationPK thesisEvaluationPK) {
        this.thesisEvaluationPK = thesisEvaluationPK;
    }

    public ThesisEvaluation(ThesisEvaluationPK thesisEvaluationPK, int thesisId, int committeeId, int evaluatorId) {
        this.thesisEvaluationPK = thesisEvaluationPK;
        this.thesisId = thesisId;
        this.committeeId = committeeId;
        this.evaluatorId = evaluatorId;
    }

    public ThesisEvaluation(int id, int thesisId1) {
        this.thesisEvaluationPK = new ThesisEvaluationPK(id, thesisId1);
    }

    public ThesisEvaluationPK getThesisEvaluationPK() {
        return thesisEvaluationPK;
    }

    public void setThesisEvaluationPK(ThesisEvaluationPK thesisEvaluationPK) {
        this.thesisEvaluationPK = thesisEvaluationPK;
    }

    public String getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(String averageScore) {
        this.averageScore = averageScore;
    }

    public int getThesisId() {
        return thesisId;
    }

    public void setThesisId(int thesisId) {
        this.thesisId = thesisId;
    }

    public int getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(int committeeId) {
        this.committeeId = committeeId;
    }

    public int getEvaluatorId() {
        return evaluatorId;
    }

    public void setEvaluatorId(int evaluatorId) {
        this.evaluatorId = evaluatorId;
    }

    @XmlTransient
    public Set<Criteria> getCriteriaSet() {
        return criteriaSet;
    }

    public void setCriteriaSet(Set<Criteria> criteriaSet) {
        this.criteriaSet = criteriaSet;
    }

    @XmlTransient
    public Set<ThesisScore> getThesisScoreSet() {
        return thesisScoreSet;
    }

    public void setThesisScoreSet(Set<ThesisScore> thesisScoreSet) {
        this.thesisScoreSet = thesisScoreSet;
    }

    public Thesis getThesis() {
        return thesis;
    }

    public void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (thesisEvaluationPK != null ? thesisEvaluationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThesisEvaluation)) {
            return false;
        }
        ThesisEvaluation other = (ThesisEvaluation) object;
        if ((this.thesisEvaluationPK == null && other.thesisEvaluationPK != null) || (this.thesisEvaluationPK != null && !this.thesisEvaluationPK.equals(other.thesisEvaluationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom21.pojo.ThesisEvaluation[ thesisEvaluationPK=" + thesisEvaluationPK + " ]";
    }
    
}
