/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom21.service;

import com.nhom21.pojo.Thesis;
import java.util.List;
import java.util.Map;

/**
 *
 * @author WIN10
 */
public interface ThesisService {
    List<Thesis> getThesis(Map<String, String> params);
    int countThesis();
    boolean addOrUpdateThesis(Thesis s);
}
