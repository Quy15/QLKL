/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.repository.impl;

import com.nhom21.pojo.ThesisParticipant;
import com.nhom21.repository.ThesisParticipantsRepository;
import java.util.ArrayList;
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
public class ThesisParticipantsImpl implements ThesisParticipantsRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<ThesisParticipant> getParti() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From ThesisParticipant");
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdateThesisParticipants(ThesisParticipant tp) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (tp.getId() == null) {
                s.save(tp);
            } else {
                s.update(tp);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public ThesisParticipant getIDP(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(ThesisParticipant.class, id);
    }

    @Override
    public boolean addOrUpdateThesisParticipants(ArrayList<ThesisParticipant> tp) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            for (int i = 0; i < tp.size(); i++) {
                if (tp.get(i).getId() == null) {
                    s.save(tp.get(i));
                } else {
                    s.update(tp.get(i));
                }
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
