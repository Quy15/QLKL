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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author WIN10
 */
@Entity
@Table(name = "user_defense_committee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDefenseCommittee.findAll", query = "SELECT u FROM UserDefenseCommittee u"),
    @NamedQuery(name = "UserDefenseCommittee.findById", query = "SELECT u FROM UserDefenseCommittee u WHERE u.id = :id")})
public class UserDefenseCommittee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "defense_committee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
//    @JsonIgnore
    private DefenseCommittee defenseCommitteeId;
    @JoinColumn(name = "defense_committee_role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private DefenseCommitteeRole defenseCommitteeRoleId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private User userId;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDefenseCommitteeId")
    private Set<ThesisScore> thesisScoreSet;

    public UserDefenseCommittee() {
    }
    
    public UserDefenseCommittee(Integer id, DefenseCommittee dc, DefenseCommitteeRole dr, User u) {
        this.id = id;
        this.defenseCommitteeId = dc;
        this.defenseCommitteeRoleId = dr;
        this.userId = u;
    }

    public UserDefenseCommittee(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DefenseCommittee getDefenseCommitteeId() {
        return defenseCommitteeId;
    }

    public void setDefenseCommitteeId(DefenseCommittee defenseCommitteeId) {
        this.defenseCommitteeId = defenseCommitteeId;
    }

    public DefenseCommitteeRole getDefenseCommitteeRoleId() {
        return defenseCommitteeRoleId;
    }

    public void setDefenseCommitteeRoleId(DefenseCommitteeRole defenseCommitteeRoleId) {
        this.defenseCommitteeRoleId = defenseCommitteeRoleId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Set<ThesisScore> getThesisScoreSet() {
        return thesisScoreSet;
    }

    public void setThesisScoreSet(Set<ThesisScore> thesisScoreSet) {
        this.thesisScoreSet = thesisScoreSet;
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
        if (!(object instanceof UserDefenseCommittee)) {
            return false;
        }
        UserDefenseCommittee other = (UserDefenseCommittee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom21.pojo.UserDefenseCommittee[ id=" + id + " ]";
    }

}
