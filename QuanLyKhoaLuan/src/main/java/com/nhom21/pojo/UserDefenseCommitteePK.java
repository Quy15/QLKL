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
public class UserDefenseCommitteePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "defense_committee_id")
    private int defenseCommitteeId;

    public UserDefenseCommitteePK() {
    }

    public UserDefenseCommitteePK(int userId, int defenseCommitteeId) {
        this.userId = userId;
        this.defenseCommitteeId = defenseCommitteeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDefenseCommitteeId() {
        return defenseCommitteeId;
    }

    public void setDefenseCommitteeId(int defenseCommitteeId) {
        this.defenseCommitteeId = defenseCommitteeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) defenseCommitteeId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDefenseCommitteePK)) {
            return false;
        }
        UserDefenseCommitteePK other = (UserDefenseCommitteePK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.defenseCommitteeId != other.defenseCommitteeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom21.pojo.UserDefenseCommitteePK[ userId=" + userId + ", defenseCommitteeId=" + defenseCommitteeId + " ]";
    }
    
}
