/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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

//        http.authorizeRequests().antMatchers("/").permitAll()
//                .antMatchers("/**/thesisManager")
//                .access("hasAnyRole('Admin', 'Giáo vụ')")
//                .antMatchers("/**/usermanager")
//                .access("hasAnyRole('Admin', 'Giáo vụ')")
//                .antMatchers("/**/addUser")
//                .access("hasAnyRole('Admin', 'Giáo vụ')")
//                .antMatchers("/**/thesisdefense")
//                .access("hasAnyRole('Admin', 'Giáo vụ')")
//                .antMatchers("/**/defenseuser")
//                .access("hasAnyRole('Admin', 'Giáo vụ')")
//                .antMatchers("/**/instructorThesis")
//                .access("hasAnyRole('Admin', 'Giáo vụ')")
//                .antMatchers("/**/thesisParticipant")
//                .access("hasAnyRole('Admin', 'Giáo vụ')")
//                ;
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
}
