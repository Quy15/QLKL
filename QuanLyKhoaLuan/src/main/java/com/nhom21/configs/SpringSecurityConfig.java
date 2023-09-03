/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.text.SimpleDateFormat;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author WIN10
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.nhom21.controllers", "com.nhom21.repository", "com.nhom21.service"})
@PropertySource("classpath:config.properties")
@Order(2)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private Environment env;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    /**
     *
     * @param http
     * @throws Exception
     */
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password");

        http.formLogin().defaultSuccessUrl("/")
                .failureUrl("/login?error");

        http.logout().logoutSuccessUrl("/login");

        http.exceptionHandling()
                .accessDeniedPage("/login?accessDenied");

        http.authorizeRequests().antMatchers("/login", "/logout").permitAll();
        http.authorizeRequests()
                .antMatchers("/thesisManager")
                .access("hasAnyRole('ROLE_ADMIN', 'ROLE_GVU')")
                .antMatchers("/usermanager")
                .access("hasAnyRole('ROLE_ADMIN', 'ROLE_GVU')")
                .antMatchers("/addUser")
                .access("hasAnyRole('ROLE_ADMIN', 'ROLE_GVU')")
                .antMatchers("/thesisdefense")
                .access("hasAnyRole('ROLE_ADMIN', 'ROLE_GVU')")
                .antMatchers("/defenseuser")
                .access("hasAnyRole('ROLE_ADMIN', 'ROLE_GVU')")
                .antMatchers("/instructorThesis")
                .access("hasAnyRole('ROLE_ADMIN', 'ROLE_GVU')")
                .antMatchers("/thesisParticipant")
                .access("hasAnyRole('ROLE_ADMIN', 'ROLE_GVU')");
        http.authorizeRequests().antMatchers("/admin").access("hasAnyRole('ROLE_ADMIN', 'ROLE_GVU')");
        http.csrf().disable();
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", "dt3oasocf",
                        "api_key", "898347928579756",
                        "api_secret", "NIsp6r_RHAC9a8hUa02dDMUp4rc",
                        "secure", true));
        return cloudinary;
    }

    @Bean
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }
    
     @Bean
    public JavaMailSenderImpl configureJavaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setUsername("nguyenphuvang3007@gmail.com");
        javaMailSender.setPassword("zcgikrkjwjbvicww");
        javaMailSender.setPort(587);
        javaMailSender.setDefaultEncoding("UTF-8");
        Properties mailProp = new Properties();
        mailProp.put("mail.smtp.starttls.enable", true);
        mailProp.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        javaMailSender.setJavaMailProperties(mailProp);
        return javaMailSender;
    }
}
