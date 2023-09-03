/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom21.repository;

import com.nhom21.pojo.ThesisParticipant;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author WIN10
 */

public interface ThesisParticipantsRepository {
    List<ThesisParticipant> getParti();
    boolean addOrUpdateThesisParticipants(ThesisParticipant tp);
    boolean addOrUpdateThesisParticipants(ArrayList<ThesisParticipant> tp);
    ThesisParticipant getIDP(int id);
}
