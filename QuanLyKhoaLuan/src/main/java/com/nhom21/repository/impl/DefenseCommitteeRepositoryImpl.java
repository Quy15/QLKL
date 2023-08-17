/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.repository.impl;

import com.nhom21.pojo.DefenseCommittee;
import com.nhom21.repository.DefenseCommitteeRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
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
public class DefenseCommitteeRepositoryImpl implements DefenseCommitteeRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public boolean addDefense(DefenseCommittee d) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (d.getId() == null) {
                s.save(d);
            } else {
                s.update(d);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<DefenseCommittee> getList() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From DefenseCommittee");
        
        return q.getResultList();
    }

    @Override
    public int countDefense() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT COUNT(*) From DefenseCommittee");

        return Integer.parseInt(q.getSingleResult().toString());
    }
    
}
