/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom21.repository;

import com.nhom21.pojo.InstructorThesis;
import com.nhom21.pojo.Thesis;
import com.nhom21.pojo.ThesisParticipant;

import java.util.ArrayList;
import com.nhom21.pojo.ThesisScore;
import java.util.List;
import java.util.Map;

/**
 *
 * @author WIN10
 */
public interface ThesisRepository {
    List<Thesis> getThesis(Map<String, String> params);
    int countThesis();
    boolean addOrUpdateThesis(Thesis s);
    Thesis getThesisById(int id);
    boolean deleteThesis(int id);
    boolean saveThesis(ArrayList<Thesis> ts);
}
