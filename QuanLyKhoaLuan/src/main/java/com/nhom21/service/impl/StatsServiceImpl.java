/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service.impl;

import com.nhom21.repository.StatsRepository;
import com.nhom21.service.StatsService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WIN10
 */
@Service
public class StatsServiceImpl implements StatsService{
    @Autowired
    private StatsRepository statsrepo;
    
    @Override
    public List<Object[]> countThesis() {
        return this.statsrepo.countThesis();
    }

    @Override
    public List<Object[]> statsScore(Map<String, String> params) {
        return this.statsrepo.statsScore(params);
    }
    
}
