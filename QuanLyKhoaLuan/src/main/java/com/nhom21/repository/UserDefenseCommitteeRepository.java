/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom21.repository;

import com.nhom21.pojo.UserDefenseCommittee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WIN10
 */
public interface UserDefenseCommitteeRepository {
    List<UserDefenseCommittee> getList();
    boolean addUserCommit(UserDefenseCommittee ud);
    boolean addUserCommit(ArrayList<UserDefenseCommittee> ud);

    UserDefenseCommittee findByDefenseId(int id);

    List<UserDefenseCommittee> getListByUID(int id);

}
