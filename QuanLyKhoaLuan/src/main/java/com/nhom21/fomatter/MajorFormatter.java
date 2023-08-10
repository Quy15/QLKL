/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.fomatter;

import com.nhom21.pojo.Major;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author WIN10
 */
public class MajorFormatter implements Formatter<Major>{

    @Override
    public String print(Major major, Locale locale) {
        return String.valueOf(major.getId());
    }

    @Override
    public Major parse(String majorId, Locale locale) throws ParseException {
        return new Major(Integer.parseInt(majorId));
    }
    
}
