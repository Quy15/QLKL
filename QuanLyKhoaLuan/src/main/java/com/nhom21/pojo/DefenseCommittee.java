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
@Table(name = "defense_committee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DefenseCommittee.findAll", query = "SELECT d FROM DefenseCommittee d"),
    @NamedQuery(name = "DefenseCommittee.findById", query = "SELECT d FROM DefenseCommittee d WHERE d.id = :id"),
    @NamedQuery(name = "DefenseCommittee.findByName", query = "SELECT d FROM DefenseCommittee d WHERE d.name = :name")})
public class DefenseCommittee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
     @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "defenseCommitteeId")
    private Set<UserDefenseCommittee> userDefenseCommitteeSet;

    public DefenseCommittee() {
    }

    public DefenseCommittee(Integer id) {
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

    @XmlTransient
    public Set<UserDefenseCommittee> getUserDefenseCommitteeSet() {
        return userDefenseCommitteeSet;
    }

    public void setUserDefenseCommitteeSet(Set<UserDefenseCommittee> userDefenseCommitteeSet) {
        this.userDefenseCommitteeSet = userDefenseCommitteeSet;
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
        if (!(object instanceof DefenseCommittee)) {
            return false;
        }
        DefenseCommittee other = (DefenseCommittee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom21.pojo.DefenseCommittee[ id=" + id + " ]";
    }
    
}
