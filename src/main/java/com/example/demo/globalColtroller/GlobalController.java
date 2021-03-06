package com.example.demo.globalColtroller;

import com.example.demo.employee.entity.Member;
import com.example.demo.employee.repository.EmployeeRepository;
import com.example.demo.employee.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller
@RequestMapping("/")
public class GlobalController implements ErrorController {

    @Autowired
    private MemberService service;

    @GetMapping("login")
    public String login(){
        if (service.findByName("admin") == null){
            Member admin = new Member();
            admin.setNom("admin");
            admin.setPassword("admin");
            service.saveAdmin(admin);
        }
        return "login";
    }
    @GetMapping("organigramme")
    public String organigramme(){
        return "image";
    }

    @RequestMapping("/default")
    public String defaultAfterLogin() {
        Collection<? extends GrantedAuthority> authorities;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        authorities = auth.getAuthorities();
        String myRole = authorities.toArray()[0].toString();
        String admin = "ADMIN";
        if (myRole.equals(admin)) {
            return "redirect:/admin/dashboard";
        }
        return "redirect:/employee/home";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
    @RequestMapping("/error")
    public String error(){
        return "404";
    }
}
