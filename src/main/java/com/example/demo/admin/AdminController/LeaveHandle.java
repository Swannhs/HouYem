package com.example.demo.admin.AdminController;

import com.example.demo.employee.entity.Leave;
import com.example.demo.employee.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin/leave")
public class LeaveHandle {
    @Autowired
    private LeaveService service;

    @ModelAttribute("leave")
    public Iterable<Leave> listOfLeave(){
        return service.findAllLeave();
    }

    @GetMapping
    public String findAllLeave(Model model){
        model.addAttribute("leave", service.findAllLeave());
        return "LeaveList";
    }

    @RequestMapping("/approve/{id}")
    public String approve(@PathVariable("id") Long id, Model model){
        Optional<Leave> leave = service.findById(id);
        leave.get().setAdmin("approve");
        service.save(leave.get());
        return "redirect:/admin/leave?approved";
    }
    @RequestMapping("/reject/{id}")
    public String reject(@PathVariable("id") Long id, Model model){
        Optional<Leave> leave = service.findById(id);
        leave.get().setAdmin("reject");
        service.save(leave.get());
        return "redirect:/admin/leave?reject";
    }

}
