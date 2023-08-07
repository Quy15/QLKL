/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service.impl;

import com.nhom21.pojo.ThesisParticipant;
import com.nhom21.repository.ThesisParticipantsRepository;
import com.nhom21.service.ThesisParticipantsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WIN10
 */
@Service
public class ThesisParticipantsServiceImpl implements ThesisParticipantsService{
    @Autowired
    private ThesisParticipantsRepository thesispRepo;
    
    @Override
    public List<ThesisParticipant> getParti() {
        return this.thesispRepo.getParti();
    }
    
}
