package com.example.demo.employee.controller;

import com.example.demo.employee.entity.Member;
import com.example.demo.employee.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/employee/home")
public class EmployeeHome {
    @Autowired
    private MemberService service;

    @ModelAttribute("member")
    public Member member(){
        return new Member();
    }

    @GetMapping
    public String home(Model model, Authentication authentication) throws ParseException {
        model.addAttribute("member", service.findByName(authentication.getName()));
        model.addAttribute("endDate", new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01"));
        return "Profile";
    }
}
