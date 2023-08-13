/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.repository.impl;

import com.nhom21.pojo.Thesis;
import com.nhom21.pojo.User;
import com.nhom21.repository.UserRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author WIN10
 */
@Repository
@PropertySource("classpath:config.properties")
@Transactional
public class UserrepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public User getUserByUserName(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From User Where username=:un");
        q.setParameter("un", username);
        return (User) q.getSingleResult();
    }

    @Override
    public List<User> getUser(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("firstName"), String.format("%%%s%%", kw)));
            }
            
            String kw2 = params.get("kw2");
            if (kw2 != null && !kw2.isEmpty()) {
                predicates.add(b.like(root.get("lastName"), String.format("%%%s%%", kw2)));
            }
            q.where(predicates.toArray(Predicate[]::new));

        }

        q.orderBy(b.asc(root.get("id")));

        Query query = s.createQuery(q);

        if (params != null) {
            String page = params.get("page");
            int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
            if (page != null) {
                query.setFirstResult((Integer.parseInt(page) - 1) * pageSize);
                query.setMaxResults(pageSize);
            }
        }

        return query.getResultList();
    }

    @Override
    public boolean register(User u) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (u.getId() == null) {
                s.save(u);
            } else {
                s.update(u);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
         return false;
    }

    @Override
    public int countUser() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT COUNT(*) From User");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public List<User> getListUser() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM User");
        
        return q.getResultList();
    }

    @Override
    public boolean deleteUser(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            User u = this.getUserById(id);
            s.delete(u);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(User.class, id);
    }

}
