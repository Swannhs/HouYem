package com.example.demo.admin.AdminController;

import com.example.demo.admin.configuration.PdfGeneratorUtil;
import com.example.demo.employee.entity.CertificateEntity;
import com.example.demo.employee.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin/certificate")
public class CertificateHandle {
    @Autowired
    private CertificateService service;

    @ModelAttribute("certificate")
    public CertificateEntity certificateEntity() {
        return new CertificateEntity();
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("certificate", service.findAll());
        return "CertificateList";
    }

    @GetMapping("/{name}")
    public String viewCertificate(@PathVariable("name") String name, Model model) {
        model.addAttribute("certificate", service.findByName(name));
        return "ViewCertificate";
    }


}
