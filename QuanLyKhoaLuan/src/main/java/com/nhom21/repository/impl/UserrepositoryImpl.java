/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.repository.impl;

import com.nhom21.pojo.Thesis;
import com.nhom21.pojo.User;
import com.nhom21.repository.UserRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
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
public class UserrepositoryImpl implements UserRepository{

    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<User> getUserById() {
         Session s = this.factory.getObject().getCurrentSession();
         Query q = s.createQuery("SELECT lastName FROM User");
         return q.getResultList();
    }

    @Override
    public User getUserByUserName(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From User Where firstname=:un");
        q.setParameter("un", username);
        return (User) q.getSingleResult();
    }
    
}
