/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service.impl;

import com.nhom21.pojo.UserDefenseCommittee;
import com.nhom21.repository.UserDefenseCommitteeRepository;
import com.nhom21.service.UserDefenseCommitteeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WIN10
 */
@Service
public class UserDefenseCommitteeServiceImpl implements UserDefenseCommitteeService{
    @Autowired
    private UserDefenseCommitteeRepository udc;
    
    @Override
    public boolean addUserCommit(UserDefenseCommittee ud) {
        String idU = String.valueOf(ud.getUserId());
        String idDR = String.valueOf(ud.getDefenseCommitteeRoleId());
        long userId = Long.parseLong(idU);
        long defenseCommitteeRoleId = Long.parseLong(idDR);
        return this.udc.addUserCommit(ud);
    }

    @Override
    public List<UserDefenseCommittee> getList() {
        return this.udc.getList();
    }
    
}
