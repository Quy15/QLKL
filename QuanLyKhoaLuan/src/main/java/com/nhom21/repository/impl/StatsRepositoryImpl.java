/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.repository.impl;

import com.nhom21.pojo.InstructorThesis;
import com.nhom21.pojo.Major;
import com.nhom21.pojo.Thesis;
import com.nhom21.pojo.ThesisParticipant;
import com.nhom21.pojo.ThesisScore;
import com.nhom21.pojo.User;
import com.nhom21.repository.StatsRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Object[]> countThesis() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rU = q.from(User.class);
        Root rT = q.from(Thesis.class);
        Root rTP = q.from(ThesisParticipant.class);
        Root rIT = q.from(InstructorThesis.class);
        Root rM = q.from(Major.class);
        q.multiselect(rM.get("name"), b.count(rT.get("id")));

        List<Predicate> pre = new ArrayList<>();
        pre.add(b.equal(rTP.get("thesisId"), rT.get("id")));
        pre.add(b.equal(rTP.get("userId"), rU.get("id")));
        pre.add(b.equal(rM.get("id"), rU.get("majorId")));

        q.where(pre.toArray(Predicate[]::new));
        q.groupBy(rM.get("name"));

        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> statsScore(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rTS = q.from(ThesisScore.class);
        Root rT = q.from(Thesis.class);
        q.multiselect(rTS.get("score"), b.count(rTS.get("score")));
        
        List<Predicate> pre = new ArrayList<>();
        pre.add(b.equal(rTS.get("thesisId"), rT.get("id")));
  
        String nam = params.get("year");
        if (nam != null && !nam.isEmpty()){
            pre.add(b.equal(b.function("YEAR", Integer.class, rT.get("date")), Integer.parseInt(nam)));
        }
        q.where(pre.toArray(Predicate[]::new));
        q.groupBy(b.function("YEAR", Integer.class, rT.get("date")), rTS.get("score"));

        Query query = s.createQuery(q);
        return query.getResultList();
    }

}
