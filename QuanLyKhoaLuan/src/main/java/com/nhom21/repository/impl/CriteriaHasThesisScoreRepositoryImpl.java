/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.repository.impl;

import com.nhom21.pojo.CriteriaHasThesisScore;
import com.nhom21.pojo.ThesisScore;
import com.nhom21.repository.CriteriaHasThesisScoreRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */@Repository
@Transactional
public class CriteriaHasThesisScoreRepositoryImpl implements CriteriaHasThesisScoreRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public List<CriteriaHasThesisScore> getListCriteriaHasThesisScore() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From CriteriaHasThesisScore");
        return q.getResultList();
    }

    @Override
    public List<CriteriaHasThesisScore> getListCriteriaHasThesisScoreByThesisScoreId(int ThesisScoreId) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From CriteriaHasThesisScore WHERE thesisScoreId.id=:id ");
        q.setParameter("id", ThesisScoreId);
        return q.getResultList();
    }
    
}
