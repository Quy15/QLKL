/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.repository.impl;

import com.nhom21.pojo.Criteria;
import com.nhom21.repository.CriteriaRepository;
import java.util.List;
import javax.persistence.Query;
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
public class CriteriaRepositoryImpl implements CriteriaRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    
    @Override
    public List<Criteria> getCri() {
        Session  s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Criteria");
        return q.getResultList();
    }

    @Override
    public Criteria getById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Criteria.class, id);
    }
    
}
