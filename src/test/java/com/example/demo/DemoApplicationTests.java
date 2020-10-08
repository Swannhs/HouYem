package com.example.demo;

import com.example.demo.employee.entity.Member;
import com.example.demo.employee.service.MemberService;
import com.example.demo.employee.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private MemberService employeeRepository;

    @Test
    void contextLoads() {

        Member admin = new Member();
        admin.setNom("admin");
        admin.setPassword("admin");
        employeeRepository.saveAdmin(admin);

    }

}
