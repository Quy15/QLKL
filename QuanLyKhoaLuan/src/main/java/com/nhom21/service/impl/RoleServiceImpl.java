/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service.impl;

import com.nhom21.pojo.Role;
import com.nhom21.repository.RoleRepository;
import com.nhom21.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author WIN10
 */
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleRepository roleRepo;
    
    @Override
    public List<Role> getRole() {
        return this.roleRepo.getRole();
    }
    
}
