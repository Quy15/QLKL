/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service.impl;

import com.nhom21.pojo.DefenseCommitteeRole;
import com.nhom21.repository.DefenseCommitteeRoleRepository;
import com.nhom21.service.DefenseCommitteeRoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WIN10
 */
@Service
public class DefenseCommitteeRoleServiceImpl implements DefenseCommitteeRoleService{
    @Autowired
    private DefenseCommitteeRoleRepository drole;
    
    @Override
    public List<DefenseCommitteeRole> getRole() {
        return this.drole.getRole();
    }

}
