/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service.impl;

import com.nhom21.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private JavaMailSenderImpl javaMailSender;
    
    @Override
    public void sendMail(String username, String email, String defenseCommittee) {
        SimpleMailMessage newEmail = new SimpleMailMessage();
        newEmail.setTo(email);
        newEmail.setSubject("Thư phân công khóa luận cho giảng viên");
        newEmail.setText("Xin chào " + username + ", giảng viên đã được phân công"
                + "cho hội đồng " + defenseCommittee);
        javaMailSender.send(newEmail);
    }

    @Override
    public void sendScore(String username, String email) {
        SimpleMailMessage newEmail = new SimpleMailMessage();
        newEmail.setTo(email);
        newEmail.setSubject("Thông báo khóa luận đã chấm xong! Mời sinh viên vào xem điểm của mình");
        newEmail.setText("Xin chào " + username + ", khóa luận của bạn đã được chấm xong."
                + "Hãy vào xem điểm và kiểm tra ");
        javaMailSender.send(newEmail);
    }
    
}
