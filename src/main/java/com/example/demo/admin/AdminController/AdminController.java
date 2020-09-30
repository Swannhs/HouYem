package com.example.demo.admin.AdminController;

import com.example.demo.employee.service.EmployeeService;
import com.example.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private EmployeeService service;

    @GetMapping("/register")
    public String register() {
        return "registration";
    }

    @ModelAttribute("employee")
    public UserEntity employee() {
        return new UserEntity();
    }

    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("employee") UserEntity employee) {
        service.save(employee);
        return "redirect:/admin/register?success";
    }


    @GetMapping("dashboard")
    public String dashboard() {
        return "dashboard";
    }
}
