/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;

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
    @Size(min = 10, max = 255, message = "{thesis.name.length}")
    @Column(name = "name")
    @NotNull(message = "{thesis.name.notNullMsg}")
    private String name;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @Size(max = 45)
    @Column(name = "status")
    @NotNull(message = "{thesis.status.notNullMsg}")
    private String status;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thesisId")
    private Set<InstructorThesis> instructorThesisSet;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thesisId")
    private Set<ThesisParticipant> thesisParticipantSet;
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
    public Set<InstructorThesis> getInstructorThesisSet() {
        return instructorThesisSet;
    }

    public void setInstructorThesisSet(Set<InstructorThesis> instructorThesisSet) {
        this.instructorThesisSet = instructorThesisSet;
    }

    @XmlTransient
    public Set<ThesisParticipant> getThesisParticipantSet() {
        return thesisParticipantSet;
    }

    public void setThesisParticipantSet(Set<ThesisParticipant> thesisParticipantSet) {
        this.thesisParticipantSet = thesisParticipantSet;
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
