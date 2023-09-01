/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.repository.impl;

import com.nhom21.pojo.ThesisScore;
import com.nhom21.repository.ThesisScoreRepository;
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
public class ThesisScoreRepositoryImpl implements ThesisScoreRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public boolean addOrUpdateThesisScore(ThesisScore ts) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (ts.getId() == null) {
                s.save(ts);
            } else {
                s.update(ts);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addOrUpdateThesisScore(ArrayList<ThesisScore> ts) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            for (int i = 0; i < ts.size(); i++) {
                if (ts.get(i).getId() == null) {
                    s.save(ts.get(i));
                } else {
                    s.update(ts.get(i));
                }
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ThesisScore> getThesisScore() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From ThesisScore");
        return q.getResultList();
    }

    @Override
    public List<ThesisScore> getThesisScoreByUserDefenseId(int UserDefenseId) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From ThesisScore Where userDefenseCommitteeId.id=:UserDefenseId AND thesisId.status !='Đã thực hiện'");
         q.setParameter("UserDefenseId", UserDefenseId);
        return q.getResultList();

    public ThesisScore findThesisScoreById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(ThesisScore.class, id);

    }

}
