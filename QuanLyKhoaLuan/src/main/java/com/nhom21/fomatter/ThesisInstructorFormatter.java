/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.fomatter;

import com.nhom21.pojo.InstructorThesis;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author WIN10
 */
public class ThesisInstructorFormatter implements Formatter<InstructorThesis>{

    @Override
    public String print(InstructorThesis thesisI, Locale locale) {
        return String.valueOf(thesisI.getUserId());
    }

    @Override
    public InstructorThesis parse(String userId, Locale locale) throws ParseException {
        return new InstructorThesis(Integer.parseInt(userId));
    }
    
}
