/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.fomatter;

import com.nhom21.pojo.ThesisParticipant;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author WIN10
 */
public class ThesisParticipantsFomatter implements Formatter<ThesisParticipant>{

    @Override
    public String print(ThesisParticipant thesisP, Locale locale) {
        return String.valueOf(thesisP.getUserId());
    }

    @Override
    public ThesisParticipant parse(String userId, Locale locale) throws ParseException {
        return new ThesisParticipant(Integer.parseInt(userId));
    }
    
}
