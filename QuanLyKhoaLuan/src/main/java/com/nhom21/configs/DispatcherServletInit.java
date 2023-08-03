/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.configs;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author WIN10
 */

public class DispatcherServletInit extends AbstractAnnotationConfigDispatcherServletInitializer{
   
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
            WebAppContextConfig.class
        };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
            HibernateConfig.class,
            TilesConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{
            "/",
            "/thesisManager"
        };
    }
    
}
