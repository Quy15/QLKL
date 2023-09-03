/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.controllers;

import com.lowagie.text.DocumentException;
import com.nhom21.pojo.DefenseCommittee;
import com.nhom21.pojo.User;
import com.nhom21.service.CriteriaHasThesisScoreService;
import com.nhom21.service.CriteriaService;
import com.nhom21.service.DefenseCommitteeRoleService;
import com.nhom21.service.DefenseCommitteeService;
import com.nhom21.service.MajorService;
import com.nhom21.service.PDFService;

import com.nhom21.service.ThesisInstructorService;
import com.nhom21.service.ThesisParticipantsService;
import com.nhom21.service.ThesisScoreService;
import com.nhom21.service.ThesisService;
import com.nhom21.service.UserDefenseCommitteeService;
import com.nhom21.service.UserService;
import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author WIN10
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:config.properties")
public class IndexController {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private Environment env;

    @Autowired
    private ThesisService thesis;

    @Autowired
    private UserService user;

    @Autowired
    private ThesisParticipantsService thesisP;

    @Autowired
    private ThesisInstructorService thesisI;

    @Autowired
    private MajorService major;

    @Autowired
    private DefenseCommitteeRoleService drole;

    @Autowired
    private DefenseCommitteeService defense;

    @Autowired
    private UserDefenseCommitteeService udc;

    @Autowired
    private ThesisScoreService tscore;

    @Autowired
    private CriteriaService cser;

    @Autowired
    private CriteriaHasThesisScoreService csser;

    @Autowired
    private PDFService pdfService;

    @RequestMapping("/")
    @Transactional
    public String index(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("thesis", this.thesis.getThesis(params));
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        int count = this.thesis.countThesis();
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        return "index";
    }

    @ModelAttribute
    public void commonAttri(Model model, @RequestParam Map<String, String> params, Principal p) {
//        if (p.getName() != null) {
//            User u = this.user.getUserByUn(p.getName());
//            String avatar = u.getAvatar();
//            model.addAttribute("avatar", avatar);
//        }
        model.addAttribute("thesis", this.thesis.getThesis(params));
        model.addAttribute("thesisP", this.thesisP.getParti());
        model.addAttribute("user", this.user.getListUser());
        model.addAttribute("thesisI", this.thesisI.getInstructor());
        model.addAttribute("major", this.major.getMajor());
        model.addAttribute("drole", this.drole.getRole());
        model.addAttribute("dc", this.defense.getList());
        model.addAttribute("udc", this.udc.getList());
        model.addAttribute("thesisscore", this.tscore.getThesisScore());
        model.addAttribute("criteria", this.cser.getCri());
        model.addAttribute("criscore", this.csser.getCriScore());
    }

    @GetMapping("/admin/pdf")
    public void generatePDF(HttpServletResponse response) throws IOException, DocumentException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename*=UTF-8''" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        response.addHeader("Content-Type", "application/pdf; charset=UTF-8");
        pdfService.export(response);
    }
}
