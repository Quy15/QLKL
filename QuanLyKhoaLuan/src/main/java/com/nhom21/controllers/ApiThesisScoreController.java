/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.nhom21.pojo.ChamDiem;
import com.nhom21.pojo.CriteriaHasThesisScore;
import com.nhom21.pojo.DiemTrungBinh;
import com.nhom21.pojo.Thesis;
import com.nhom21.pojo.ThesisParticipant;
import com.nhom21.pojo.ThesisScore;
import com.nhom21.pojo.UserDefenseCommittee;
import com.nhom21.service.CriteriaHasThesisScoreService;
import com.nhom21.service.ThesisParticipantsService;
import com.nhom21.service.ThesisScoreService;
import com.nhom21.service.UserDefenseCommitteeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class ApiThesisScoreController {
    @Autowired
    private ThesisScoreService thesisScore;
    @Autowired
    private UserDefenseCommitteeService userDefenseCommitteeService;
    @Autowired
    private CriteriaHasThesisScoreService criteriaHasThesisScoreService;
    @Autowired
    private ThesisScoreService thesisScoreService;
    @Autowired
    private ThesisParticipantsService thesisParticipantsService;
    
    @GetMapping("/api/thesiscores/{id}")
    @CrossOrigin
    public ResponseEntity<List<ThesisScore>> getThesisScoresByUserDefenseCommitteeId(@PathVariable("id") int userDefenseCommitteeId) {
         List<ThesisScore> thesisScores = this.thesisScore.getThesisScoreByUserDefenseId(userDefenseCommitteeId);
         if (thesisScores == null){
             return new ResponseEntity<>(thesisScores, HttpStatus.NOT_FOUND);
         }
        return new ResponseEntity<>(thesisScores, HttpStatus.OK);
    }
    
    @GetMapping("/api/thesis-by-user/{id}")
    @CrossOrigin
    public ResponseEntity<List<DiemTrungBinh>> getThesisByUserId(@PathVariable("id") int userId) {
         List<ThesisParticipant> tp = this.thesisParticipantsService.getThesisIdByUser(userId);
         List<DiemTrungBinh> dtb = new ArrayList<>();
         for(int i = 0; i < tp.size(); i++){
            int thesisId = tp.get(i).getThesisId().getId();
            Double averageScore = this.thesisScore.getAverageScoreByThesisId(thesisId);
            String thesisName = tp.get(i).getThesisId().getName();

            DiemTrungBinh diemTrungBinh = new DiemTrungBinh();
            diemTrungBinh.setDiemTB(averageScore);
            diemTrungBinh.setThesisName(thesisName);
            diemTrungBinh.setThesisId(thesisId);

            dtb.add(diemTrungBinh);
         }
         if (dtb == null){
             return new ResponseEntity<>(dtb, HttpStatus.NOT_FOUND);
         }
        return new ResponseEntity<>(dtb, HttpStatus.OK);
    }
    
    @GetMapping(path = "/api/userDefense/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<List<UserDefenseCommittee>> getUserDefenseCommitteeByUserId(@PathVariable(value = "id") int userId){
        List<UserDefenseCommittee> userDefenseCommittee= this.userDefenseCommitteeService.getListByUID(userId);
        if (userDefenseCommittee == null){
            return new ResponseEntity<>(userDefenseCommittee, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDefenseCommittee, HttpStatus.OK);
    }
    
    @GetMapping("/api/criteria-thesis-score/{id}")
    @CrossOrigin
    public ResponseEntity<List<CriteriaHasThesisScore>> getListCriteriaHasThesisScoreByThesisScoreId(@PathVariable("id") int thesisScoreId) {
         List<CriteriaHasThesisScore> criteriaHasThesisScore = this.criteriaHasThesisScoreService.getListCriteriaHasThesisScoreByThesisScoreId(thesisScoreId);
         if (criteriaHasThesisScore == null){
             return new ResponseEntity<>(criteriaHasThesisScore, HttpStatus.NOT_FOUND);
         }
        return new ResponseEntity<>(criteriaHasThesisScore, HttpStatus.OK);
    }
    
    @PostMapping(path = "/api/cham-diem/", 
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<String> chamDiem(@RequestBody ChamDiem chamDiemObj) {
        int thesisScoreId = chamDiemObj.getThesisScoreId();
        String score = chamDiemObj.getScore();
        ThesisScore tsObj = this.thesisScoreService.findThesisScoreById(thesisScoreId);
            
        tsObj.setScore(score);
        this.thesisScoreService.addOrUpdateThesisScore(tsObj);

        return new ResponseEntity<>("Lưu điểm thành công", HttpStatus.OK);
    }
}
