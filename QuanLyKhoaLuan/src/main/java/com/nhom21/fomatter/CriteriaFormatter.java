/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.fomatter;

import com.nhom21.pojo.Criteria;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;
/**
 *
 * @author WIN10
 */
public class CriteriaFormatter implements Formatter<Criteria>{

    @Override
    public String print(Criteria cri, Locale locale) {
        return String.valueOf(cri.getId());
    }

    @Override
    public Criteria parse(String criteriaId, Locale locale) throws ParseException {
        return new Criteria(Integer.parseInt(criteriaId));
    }
    
}
