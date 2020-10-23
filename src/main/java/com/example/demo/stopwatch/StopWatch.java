package com.example.demo.stopwatch;

import com.example.demo.employee.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Controller
@RequestMapping("/")
public class StopWatch {
    @Autowired
    private WatchRepository repository;

    @Autowired
    private MemberService service;

    @PostMapping("/time")
    public String time(@RequestBody String time,String name){
        System.out.println("-----------------------------------------------------------");
        System.out.println(name);
        WatchEntity entity = new WatchEntity();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        entity.setDate(dateTimeFormatter.format(now));
        entity.setSpendTime(time);
        entity.setName(service.findByName(name).getNom());
        repository.save(entity);
        return "redirect:/employee/home";
    }
}
