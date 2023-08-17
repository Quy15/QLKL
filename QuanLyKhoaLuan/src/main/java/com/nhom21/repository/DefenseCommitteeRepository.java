/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom21.repository;

import com.nhom21.pojo.DefenseCommittee;
import java.util.List;

/**
 *
 * @author WIN10
 */
public interface DefenseCommitteeRepository {
    List<DefenseCommittee> getList();
    boolean addDefense(DefenseCommittee d);
    int countDefense();
}
