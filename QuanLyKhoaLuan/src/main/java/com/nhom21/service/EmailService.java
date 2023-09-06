/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service;

/**
 *
 * @author Admin
 */
public interface EmailService {
   void sendMail(String username, String email, String thesis_id);
   void sendScore(String username, String email);
}
