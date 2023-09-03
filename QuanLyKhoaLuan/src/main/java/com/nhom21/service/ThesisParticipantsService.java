/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom21.service;

import com.nhom21.pojo.ThesisParticipant;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WIN10
 */
public interface ThesisParticipantsService {

    List<ThesisParticipant> getParti();

    boolean addOrUpdateThesisParticipants(ThesisParticipant tp);
    public boolean addOrUpdateThesisParticipants(ArrayList<ThesisParticipant> tp);
    ThesisParticipant getIDP(int id);
}
