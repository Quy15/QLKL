/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.repository.impl;

import com.nhom21.pojo.InstructorThesis;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.nhom21.repository.ThesisInstructorRepository;
import java.util.ArrayList;
import org.hibernate.HibernateException;

/**
 *
 * @author WIN10
 */
@Repository
@Transactional
public class ThesisInstructorRepoImpl implements ThesisInstructorRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<InstructorThesis> getInstructor() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From InstructorThesis");

        return q.getResultList();
    }

    @Override
    public boolean addOrUpdateThesisInstructor(InstructorThesis ti) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (ti.getId() == null) {

                s.save(ti);
            } else {
                s.update(ti);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public InstructorThesis getIDI(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(InstructorThesis.class, id);
    }

    @Override
    public boolean addOrUpdateThesisInstructor(ArrayList<InstructorThesis> ti) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            for (int i = 0; i < ti.size(); i++) {
                if (ti.get(i).getId() == null) {

                    s.save(ti.get(i));
                } else {
                    s.update(ti.get(i));
                }
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
