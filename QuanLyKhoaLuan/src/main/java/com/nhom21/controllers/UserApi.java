/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.Thesis;
import com.nhom21.pojo.ThesisParticipant;
import com.nhom21.pojo.User;
import com.nhom21.service.ThesisParticipantsService;
import com.nhom21.service.ThesisService;
import com.nhom21.service.UserService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.nhom21.components.JwtService;
import com.nhom21.pojo.ChangePassword;
import com.nhom21.pojo.User;
import com.nhom21.service.UserService;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author WIN10
 */

@RestController
public class UserApi {
    @Autowired
    private UserService user;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private BCryptPasswordEncoder passencoder;
    @PostMapping("/api/login/")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody User user) {
        if (this.user.authUser(user.getUsername(), user.getPassword()) == true) {
            String token = this.jwtService.generateTokenLogin(user.getUsername());
            
            return new ResponseEntity<>(token, HttpStatus.OK);
        }

        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }
    
     @GetMapping("/api/test/")
    @CrossOrigin(origins = {"127.0.0.1:5500"})
    public ResponseEntity<String> test(Principal pricipal) {
        return new ResponseEntity<>("SUCCESSFUL", HttpStatus.OK);
    }
    
    
    @DeleteMapping("/addUser/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable("id") int id){
        this.user.deleteUser(id);
    }

    @GetMapping(path = "/api/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<User> details(Principal user) {
        User u = this.user.getUserByUn(user.getName());
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
    
    @GetMapping("/api/users/")
    @CrossOrigin
    public ResponseEntity<List<User>> list(@RequestParam Map<String, String> params){
        return new ResponseEntity<>(this.user.getUser(params), HttpStatus.OK);
    }
    
    @PostMapping(path = "/api/change-password/", 
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<String> changePassword(@RequestBody ChangePassword request) {
        String username = request.getUsername();
        String oldPassword = request.getOldPassword();
        String newPassword = request.getNewPassword();
        User u = this.user.findUserByUserName(username);
        

        if (u == null || !passencoder.matches(oldPassword, u.getPassword())) {
            return new ResponseEntity<>("Sai mật khẩu", HttpStatus.UNAUTHORIZED);
        }

        String hashedNewPassword = passencoder.encode(newPassword);
        u.setPassword(hashedNewPassword);
        this.user.saveUser(u);

        return new ResponseEntity<>("Đổi mật khẩu thành công", HttpStatus.OK);
    }

}
