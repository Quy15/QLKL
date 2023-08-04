/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.repository.impl;

import com.nhom21.pojo.Role;
import com.nhom21.repository.RoleRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 *
 * @author WIN10
 */
public class RolerepositoryImpl implements RoleRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Role> getRole() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Role");
        return q.getResultList();
    }
    
}
