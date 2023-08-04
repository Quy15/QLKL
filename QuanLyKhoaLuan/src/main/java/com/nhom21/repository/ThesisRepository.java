/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom21.repository;

import com.nhom21.pojo.Thesis;
import java.util.List;
import java.util.Map;

/**
 *
 * @author WIN10
 */
public interface ThesisRepository {
    List<Thesis> getThesis(Map<String, String> params);
    int countThesis();
    boolean addOrUpdateThesis(Thesis s, String date);
    Thesis getThesisById(int id);
    boolean deleteThesis(int id);
}
