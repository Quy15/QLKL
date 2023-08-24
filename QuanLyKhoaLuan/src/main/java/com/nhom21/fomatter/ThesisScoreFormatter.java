/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.fomatter;

import com.nhom21.pojo.ThesisScore;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author WIN10
 */
public class ThesisScoreFormatter implements Formatter<ThesisScore>{

    @Override
    public String print(ThesisScore tscore, Locale locale) {
        return String.valueOf(tscore.getId());
    }

    @Override
    public ThesisScore parse(String thesisScoreId, Locale locale) throws ParseException {
        return new ThesisScore(Integer.parseInt(thesisScoreId));
    }
    
}
