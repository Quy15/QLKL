/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service.impl;

import com.nhom21.pojo.Criteria;
import com.nhom21.repository.CriteriaRepository;
import com.nhom21.service.CriteriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WIN10
 */
@Service
public class CriteriaServiceImpl implements CriteriaService{
    @Autowired
    private CriteriaRepository crepo;
    
    @Override
    public List<Criteria> getCri() {
        return this.crepo.getCri();
    }
    
}
