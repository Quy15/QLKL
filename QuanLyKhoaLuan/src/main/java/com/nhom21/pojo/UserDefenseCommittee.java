/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.pojo;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "user_defense_committee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDefenseCommittee.findAll", query = "SELECT u FROM UserDefenseCommittee u"),
    @NamedQuery(name = "UserDefenseCommittee.findByUserId", query = "SELECT u FROM UserDefenseCommittee u WHERE u.userDefenseCommitteePK.userId = :userId"),
    @NamedQuery(name = "UserDefenseCommittee.findByDefenseCommitteeId", query = "SELECT u FROM UserDefenseCommittee u WHERE u.userDefenseCommitteePK.defenseCommitteeId = :defenseCommitteeId")})
public class UserDefenseCommittee implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserDefenseCommitteePK userDefenseCommitteePK;
    @JoinColumn(name = "defense_committee_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DefenseCommittee defenseCommittee;
    @JoinColumn(name = "defense_committee_role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DefenseCommitteeRole defenseCommitteeRoleId;
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public UserDefenseCommittee() {
    }

    public UserDefenseCommittee(UserDefenseCommitteePK userDefenseCommitteePK) {
        this.userDefenseCommitteePK = userDefenseCommitteePK;
    }

    public UserDefenseCommittee(int userId, int defenseCommitteeId) {
        this.userDefenseCommitteePK = new UserDefenseCommitteePK(userId, defenseCommitteeId);
    }

    public UserDefenseCommitteePK getUserDefenseCommitteePK() {
        return userDefenseCommitteePK;
    }

    public void setUserDefenseCommitteePK(UserDefenseCommitteePK userDefenseCommitteePK) {
        this.userDefenseCommitteePK = userDefenseCommitteePK;
    }

    public DefenseCommittee getDefenseCommittee() {
        return defenseCommittee;
    }

    public void setDefenseCommittee(DefenseCommittee defenseCommittee) {
        this.defenseCommittee = defenseCommittee;
    }

    public DefenseCommitteeRole getDefenseCommitteeRoleId() {
        return defenseCommitteeRoleId;
    }

    public void setDefenseCommitteeRoleId(DefenseCommitteeRole defenseCommitteeRoleId) {
        this.defenseCommitteeRoleId = defenseCommitteeRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userDefenseCommitteePK != null ? userDefenseCommitteePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDefenseCommittee)) {
            return false;
        }
        UserDefenseCommittee other = (UserDefenseCommittee) object;
        if ((this.userDefenseCommitteePK == null && other.userDefenseCommitteePK != null) || (this.userDefenseCommitteePK != null && !this.userDefenseCommitteePK.equals(other.userDefenseCommitteePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom21.pojo.UserDefenseCommittee[ userDefenseCommitteePK=" + userDefenseCommitteePK + " ]";
    }
    
}
