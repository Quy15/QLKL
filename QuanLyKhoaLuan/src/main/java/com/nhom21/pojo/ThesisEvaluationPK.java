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
public class ThesisEvaluationPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thesis_id1")
    private int thesisId1;

    public ThesisEvaluationPK() {
    }

    public ThesisEvaluationPK(int id, int thesisId1) {
        this.id = id;
        this.thesisId1 = thesisId1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThesisId1() {
        return thesisId1;
    }

    public void setThesisId1(int thesisId1) {
        this.thesisId1 = thesisId1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) thesisId1;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThesisEvaluationPK)) {
            return false;
        }
        ThesisEvaluationPK other = (ThesisEvaluationPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.thesisId1 != other.thesisId1) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom21.pojo.ThesisEvaluationPK[ id=" + id + ", thesisId1=" + thesisId1 + " ]";
    }
    
}
