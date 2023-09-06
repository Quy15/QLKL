/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom21.service;

import com.nhom21.pojo.UserDefenseCommittee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WIN10
 */
public interface UserDefenseCommitteeService {
    boolean addUserCommit(UserDefenseCommittee ud);
    List<UserDefenseCommittee> getList();
    public boolean addUserCommit(ArrayList<UserDefenseCommittee> ud);

    public UserDefenseCommittee findByDefenseId(int id);

    List<UserDefenseCommittee> getListByUID(int id);

}
