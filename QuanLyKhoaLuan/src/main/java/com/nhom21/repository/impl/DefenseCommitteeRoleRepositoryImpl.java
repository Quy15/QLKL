/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.repository.impl;

import com.nhom21.pojo.DefenseCommitteeRole;
import com.nhom21.repository.DefenseCommitteeRoleRepository;
import java.util.List;
import javax.persistence.Query;
import org.eclipse.persistence.annotations.ReadOnly;
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
public class DefenseCommitteeRoleRepositoryImpl implements DefenseCommitteeRoleRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<DefenseCommitteeRole> getRole() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From DefenseCommitteeRole");
        
        return q.getResultList();
    }

    @Override
    public DefenseCommitteeRole getById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(DefenseCommitteeRole.class, id);
    }
    
}
