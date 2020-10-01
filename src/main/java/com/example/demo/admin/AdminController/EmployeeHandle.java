package com.example.demo.admin.AdminController;

import com.example.demo.employee.entity.Member;
import com.example.demo.employee.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/admin/employees")
public class EmployeeHandle {
    @Autowired
    private MemberService service;

    @ModelAttribute("listEmployee")
    public Iterable<Member> listOfEmployee() {
        return service.findAllEmployees();
    }

    @GetMapping
    public ModelAndView findAllEmployee() {
        ModelAndView mv = new ModelAndView("employees");
        mv.addObject("listEmployee", service.findAllEmployees());
        return mv;
    }
    @GetMapping("/{id}")
    public String profile(@PathVariable("id") Long id, Model model){
        model.addAttribute("info", service.findById(id));
        return "EmployeeInfo";
    }
    @RequestMapping("/delete/{id}")
//    @PreAuthorize("hasAuthority('admin:write')")
    public String delete(@PathVariable("id") Long id){
        service.deleteById(id);
        return "redirect:/admin/employees?success";
    }

    @ModelAttribute("employee")
    public Member employee(){
        return new Member();
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        Optional<Member> employee = service.findById(id);
        model.addAttribute("employee", employee);
        return "EmployeeUpdate";
    }
}
