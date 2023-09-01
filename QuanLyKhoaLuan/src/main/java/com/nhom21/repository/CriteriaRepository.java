/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom21.repository;

import com.nhom21.pojo.Criteria;
import java.util.List;

/**
 *
 * @author WIN10
 */
public interface CriteriaRepository {
    List<Criteria> getCri();
    Criteria getById(int id);
}
