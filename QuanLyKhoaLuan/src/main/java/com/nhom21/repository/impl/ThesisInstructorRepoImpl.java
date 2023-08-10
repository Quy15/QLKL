/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.repository.impl;

import com.nhom21.pojo.InstructorThesis;
import com.nhom21.repository.ThesisInstructionRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author WIN10
 */
@Repository
@Transactional
public class ThesisInstructorRepoImpl implements ThesisInstructionRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<InstructorThesis> getInstructor() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From InstructorThesis");
        
        return q.getResultList();
    }
    
}
