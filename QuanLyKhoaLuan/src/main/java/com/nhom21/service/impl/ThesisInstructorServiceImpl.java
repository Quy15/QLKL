/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service.impl;

import com.nhom21.pojo.InstructorThesis;
import com.nhom21.repository.ThesisInstructionRepository;
import com.nhom21.repository.impl.ThesisInstructorRepoImpl;
import com.nhom21.service.ThesisInstructorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WIN10
 */
@Service
public class ThesisInstructorServiceImpl implements ThesisInstructorService{
    @Autowired
    private ThesisInstructionRepository thesisI;
    
    @Override
    public List<InstructorThesis> getInstructor() {
        return this.thesisI.getInstructor();
    }
    
    
}
