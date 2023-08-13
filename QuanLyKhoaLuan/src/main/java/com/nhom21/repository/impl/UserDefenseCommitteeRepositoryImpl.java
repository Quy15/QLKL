/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.repository.impl;

import com.nhom21.pojo.UserDefenseCommittee;
import com.nhom21.repository.UserDefenseCommitteeRepository;
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
public class UserDefenseCommitteeRepositoryImpl implements UserDefenseCommitteeRepository{
     @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public boolean addUserCommit(UserDefenseCommittee ud) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (ud.getId() == null) {
                s.save(ud);
            } else {
                s.update(ud);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
