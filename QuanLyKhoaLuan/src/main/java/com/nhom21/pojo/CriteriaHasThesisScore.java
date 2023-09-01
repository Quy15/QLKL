/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WIN10
 */
@Entity
@Table(name = "criteria_has_thesis_score")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriteriaHasThesisScore.findAll", query = "SELECT c FROM CriteriaHasThesisScore c"),
    @NamedQuery(name = "CriteriaHasThesisScore.findById", query = "SELECT c FROM CriteriaHasThesisScore c WHERE c.id = :id")})
public class CriteriaHasThesisScore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "criteria_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Criteria criteriaId;
    @JoinColumn(name = "thesis_score_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
//    @JsonIgnore
    private ThesisScore thesisScoreId;

    public CriteriaHasThesisScore() {
    }
    
    public CriteriaHasThesisScore(Integer id, Criteria cri, ThesisScore ts) {
        this.id = id;
        this.criteriaId = cri;
        this.thesisScoreId = ts;
    }
    
    public CriteriaHasThesisScore(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Criteria getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(Criteria criteriaId) {
        this.criteriaId = criteriaId;
    }

    public ThesisScore getThesisScoreId() {
        return thesisScoreId;
    }

    public void setThesisScoreId(ThesisScore thesisScoreId) {
        this.thesisScoreId = thesisScoreId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriaHasThesisScore)) {
            return false;
        }
        CriteriaHasThesisScore other = (CriteriaHasThesisScore) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom21.pojo.CriteriaHasThesisScore[ id=" + id + " ]";
    }
    
}
