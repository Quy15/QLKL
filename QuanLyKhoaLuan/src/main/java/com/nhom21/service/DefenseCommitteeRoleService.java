/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom21.service;

import com.nhom21.pojo.DefenseCommitteeRole;
import java.util.List;

/**
 *
 * @author WIN10
 */
public interface DefenseCommitteeRoleService {
    List<DefenseCommitteeRole> getRole();
    DefenseCommitteeRole getById(int id);
}
