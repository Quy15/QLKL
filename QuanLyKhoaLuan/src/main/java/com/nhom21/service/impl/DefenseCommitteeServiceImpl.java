/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service.impl;

import com.nhom21.pojo.DefenseCommittee;
import com.nhom21.repository.DefenseCommitteeRepository;
import com.nhom21.service.DefenseCommitteeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WIN10
 */
@Service
public class DefenseCommitteeServiceImpl implements DefenseCommitteeService{
    @Autowired
    private DefenseCommitteeRepository defense;
    
    @Override
    public boolean addDefense(DefenseCommittee d) {
        return this.defense.addDefense(d);
    }

    @Override
    public List<DefenseCommittee> getList() {
        return this.defense.getList();
    }

    @Override
    public int countDefense() {
        return this.defense.countDefense();
    }
    
}
