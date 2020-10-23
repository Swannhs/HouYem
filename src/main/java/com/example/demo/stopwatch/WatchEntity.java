package com.example.demo.stopwatch;

import com.example.demo.employee.entity.Member;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Working_Time")
public class WatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private String name;

    private String spendTime;
}
