package com.example.demo.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee/home")
public class EmployeeHome {
    @GetMapping
    public String home(){
        return "EmployeeStart";
    }
}
