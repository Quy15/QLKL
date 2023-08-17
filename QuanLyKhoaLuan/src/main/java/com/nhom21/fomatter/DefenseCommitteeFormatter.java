/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.fomatter;

import com.nhom21.pojo.DefenseCommittee;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author WIN10
 */
public class DefenseCommitteeFormatter implements Formatter<DefenseCommittee>{

    @Override
    public String print(DefenseCommittee defenseCommittee, Locale locale) {
        return String.valueOf(defenseCommittee.getId());
    }

    @Override
    public DefenseCommittee parse(String defenseCommitteeId, Locale locale) throws ParseException {
        return new DefenseCommittee(Integer.parseInt(defenseCommitteeId));
    }
    
}
