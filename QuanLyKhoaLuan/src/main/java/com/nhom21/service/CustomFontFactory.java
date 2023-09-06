/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service;

import com.lowagie.text.FontFactory;

/**
 *
 * @author Admin
 */
public class CustomFontFactory {
     public static void registerCustomFonts() {
        FontFactory.register("path/to/custom-font.ttf", "CustomFont");
    }
}
