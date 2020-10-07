package com.example.demo.employee.controller;

import com.example.demo.employee.entity.Leave;
import com.example.demo.employee.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee/leave")
public class LeaveController {
    @Autowired
    private LeaveService service;

    @ModelAttribute("leave")
    public Leave leave(){
        return new Leave();
    }

    @GetMapping
    public String application(){
        return "leave";
    }

    @PostMapping
    public String leave(Leave leave){
        service.save(leave);
        return "redirect:/employee/leave?success";
    }
}


// this method will call that class
// when employee hit this url than ths operation will be execute ok