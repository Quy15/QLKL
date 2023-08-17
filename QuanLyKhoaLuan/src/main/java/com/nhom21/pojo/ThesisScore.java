/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author WIN10
 */
@Entity
@Table(name = "thesis_score")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThesisScore.findAll", query = "SELECT t FROM ThesisScore t"),
    @NamedQuery(name = "ThesisScore.findById", query = "SELECT t FROM ThesisScore t WHERE t.id = :id"),
    @NamedQuery(name = "ThesisScore.findByName", query = "SELECT t FROM ThesisScore t WHERE t.name = :name"),
    @NamedQuery(name = "ThesisScore.findByScore", query = "SELECT t FROM ThesisScore t WHERE t.score = :score")})
public class ThesisScore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "score")
    private String score;
    @JoinColumn(name = "thesis_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Thesis thesisId;
    @JoinColumn(name = "user_defense_committee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserDefenseCommittee userDefenseCommitteeId;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thesisScoreId")
    private Set<CriteriaHasThesisScore> criteriaHasThesisScoreSet;

    public ThesisScore() {
    }

    public ThesisScore(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Thesis getThesisId() {
        return thesisId;
    }

    public void setThesisId(Thesis thesisId) {
        this.thesisId = thesisId;
    }

    public UserDefenseCommittee getUserDefenseCommitteeId() {
        return userDefenseCommitteeId;
    }

    public void setUserDefenseCommitteeId(UserDefenseCommittee userDefenseCommitteeId) {
        this.userDefenseCommitteeId = userDefenseCommitteeId;
    }

    @XmlTransient
    public Set<CriteriaHasThesisScore> getCriteriaHasThesisScoreSet() {
        return criteriaHasThesisScoreSet;
    }

    public void setCriteriaHasThesisScoreSet(Set<CriteriaHasThesisScore> criteriaHasThesisScoreSet) {
        this.criteriaHasThesisScoreSet = criteriaHasThesisScoreSet;
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
        if (!(object instanceof ThesisScore)) {
            return false;
        }
        ThesisScore other = (ThesisScore) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom21.pojo.ThesisScore[ id=" + id + " ]";
    }
    
}
