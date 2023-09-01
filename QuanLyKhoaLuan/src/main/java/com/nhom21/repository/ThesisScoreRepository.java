/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom21.repository;

import com.nhom21.pojo.ThesisScore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WIN10
 */
public interface ThesisScoreRepository {
    List<ThesisScore> getThesisScore();
    List<ThesisScore> getThesisScoreByUserDefenseId(int UserDefenseId);
    boolean addOrUpdateThesisScore(ThesisScore ts);
    boolean addOrUpdateThesisScore(ArrayList<ThesisScore> ts);
    ThesisScore findThesisScoreById(int id);
}
