package com.example.demo.employee.controller;

import com.example.demo.employee.entity.CertificateEntity;
import com.example.demo.employee.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee/certificate")
public class CertificateController {
    @Autowired
    private CertificateService service;

    @GetMapping
    public String certificate(){
        return "Certification";
    }

    @ModelAttribute("certificate")
    public CertificateEntity certificateEntity(){
        return new CertificateEntity();
    }
    @PostMapping
    public String leave(CertificateEntity entity){
        service.save(entity);
        return "redirect:/employee/certificate?success";
    }

}
