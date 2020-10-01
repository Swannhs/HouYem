package com.example.demo.admin.AdminController;

import com.example.demo.employee.entity.Member;
import com.example.demo.employee.service.MemberService;
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
    private MemberService service;

    @GetMapping("/register")
    public String register() {
        return "registration";
    }

    @ModelAttribute("member")
    public Member employee() {
        return new Member();
    }

    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("member") Member member) {
        service.save(member);
        return "redirect:/admin/register?success";
    }


    @GetMapping("dashboard")
    public String dashboard() {
        return "dashboard";
    }
}
