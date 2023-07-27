/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author WIN10
 */
@Embeddable
public class ThesisScorePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thesis_evaluation_id")
    private int thesisEvaluationId;

    public ThesisScorePK() {
    }

    public ThesisScorePK(int id, int thesisEvaluationId) {
        this.id = id;
        this.thesisEvaluationId = thesisEvaluationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThesisEvaluationId() {
        return thesisEvaluationId;
    }

    public void setThesisEvaluationId(int thesisEvaluationId) {
        this.thesisEvaluationId = thesisEvaluationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) thesisEvaluationId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThesisScorePK)) {
            return false;
        }
        ThesisScorePK other = (ThesisScorePK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.thesisEvaluationId != other.thesisEvaluationId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom21.pojo.ThesisScorePK[ id=" + id + ", thesisEvaluationId=" + thesisEvaluationId + " ]";
    }
    
}
