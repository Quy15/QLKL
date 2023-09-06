/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service.impl;

import com.nhom21.pojo.UserDefenseCommittee;
import com.nhom21.repository.UserDefenseCommitteeRepository;
import com.nhom21.service.UserDefenseCommitteeService;
import java.util.ArrayList;
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
        return this.udc.addUserCommit(ud);
    }

    @Override
    public List<UserDefenseCommittee> getList() {
        return this.udc.getList();
    }

    @Override
    public boolean addUserCommit(ArrayList<UserDefenseCommittee> ud) {
        return this.udc.addUserCommit(ud);
    }

    @Override

    public UserDefenseCommittee findByDefenseId(int id) {
        return this.udc.findByDefenseId(id);
    }
    

    public List<UserDefenseCommittee> getListByUID(int id) {
        return this.udc.getListByUID(id);
    }

}
