/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author WIN10
 */
@Entity
@Table(name = "thesis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thesis.findAll", query = "SELECT t FROM Thesis t"),
    @NamedQuery(name = "Thesis.findById", query = "SELECT t FROM Thesis t WHERE t.id = :id"),
    @NamedQuery(name = "Thesis.findByName", query = "SELECT t FROM Thesis t WHERE t.name = :name"),
    @NamedQuery(name = "Thesis.findByDate", query = "SELECT t FROM Thesis t WHERE t.date = :date"),
    @NamedQuery(name = "Thesis.findByStatus", query = "SELECT t FROM Thesis t WHERE t.status = :status")})
public class Thesis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Size(min = 10, max = 255,  message = "{thesis.name.length}")
    @Column(name = "name")
    @NotNull(message = "{thesis.name.notNullMsg}")
    private String name;
    
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    public Date convertDate(String d) throws ParseException{
        date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
        return date;
    }
    
    @Size(max = 45)
    @Column(name = "status")
    @NotNull(message = "{thesis.status.notNullMsg}")
    private String status;
    
    @JoinTable(name = "instructor_thesis", joinColumns = {
        @JoinColumn(name = "thesis_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id")})
    @JsonIgnore
    @ManyToMany
    private Set<User> userSet;
    
    @JoinTable(name = "thesis_participant", joinColumns = {
        @JoinColumn(name = "thesis_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id")})
    @JsonIgnore
    @ManyToMany
    private Set<User> userSet1;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thesisId")
    private Set<ThesisScore> thesisScoreSet;

    public Thesis() {
    }

    public Thesis(Integer id) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    @XmlTransient
    public Set<User> getUserSet1() {
        return userSet1;
    }

    public void setUserSet1(Set<User> userSet1) {
        this.userSet1 = userSet1;
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
        if (!(object instanceof Thesis)) {
            return false;
        }
        Thesis other = (Thesis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom21.pojo.Thesis[ id=" + id + " ]";
    }
    
}
