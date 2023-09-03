/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom21.repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author WIN10
 */
public interface StatsRepository {
    public List<Object[]> countThesis();
    public List<Object[]> statsScore(Map<String,String> params);
}
