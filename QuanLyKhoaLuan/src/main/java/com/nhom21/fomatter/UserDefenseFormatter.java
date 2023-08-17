/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.fomatter;

import com.nhom21.pojo.UserDefenseCommittee;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author WIN10
 */
public class UserDefenseFormatter implements Formatter<UserDefenseCommittee>{

    @Override
    public String print(UserDefenseCommittee udc, Locale locale) {
        return String.valueOf(udc.getUserId());
    }

    @Override
    public UserDefenseCommittee parse(String userId, Locale locale) throws ParseException {
        return new UserDefenseCommittee(Integer.parseInt(userId));
    }
    
}
