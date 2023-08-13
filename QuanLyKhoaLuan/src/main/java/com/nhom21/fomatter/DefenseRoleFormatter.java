/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.fomatter;

import com.nhom21.pojo.DefenseCommitteeRole;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author WIN10
 */
public class DefenseRoleFormatter implements Formatter<DefenseCommitteeRole>{

    @Override
    public String print(DefenseCommitteeRole drole, Locale locale) {
        return String.valueOf(drole.getId());
    }

    @Override
    public DefenseCommitteeRole parse(String defenseCommitteeRoleId, Locale locale) throws ParseException {
        return new DefenseCommitteeRole(Integer.parseInt(defenseCommitteeRoleId));
    }
    
}
