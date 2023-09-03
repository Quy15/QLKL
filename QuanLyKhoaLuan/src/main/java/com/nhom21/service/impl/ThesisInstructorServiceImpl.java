/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service.impl;

import com.nhom21.pojo.InstructorThesis;
import com.nhom21.repository.impl.ThesisInstructorRepoImpl;
import com.nhom21.service.ThesisInstructorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nhom21.repository.ThesisInstructorRepository;
import java.util.ArrayList;

/**
 *
 * @author WIN10
 */
@Service
public class ThesisInstructorServiceImpl implements ThesisInstructorService{
    @Autowired
    private ThesisInstructorRepository thesisI;
    
    @Override
    public List<InstructorThesis> getInstructor() {
        return this.thesisI.getInstructor();
    }

    @Override
    public boolean addOrUpdateThesisInstructor(InstructorThesis ti) {
        return this.thesisI.addOrUpdateThesisInstructor(ti);
    }

    @Override
    public InstructorThesis getIDI(int id) {
        return this.thesisI.getIDI(id);
    }

    @Override
    public boolean addOrUpdateThesisInstructor(ArrayList<InstructorThesis> ti) {
        return this.thesisI.addOrUpdateThesisInstructor(ti);
    }
    
    
}
