/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service.impl;

import com.nhom21.pojo.Major;
import com.nhom21.repository.MajorRepository;
import com.nhom21.service.MajorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WIN10
 */
@Service
public class MajorServiceImpl implements MajorService{
    @Autowired
    private MajorRepository major;
    
    @Override
    public List<Major> getMajor() {
        return this.major.getMajor();
    }
    
}
